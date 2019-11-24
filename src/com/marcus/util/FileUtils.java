package com.marcus.util;

import java.io.*;

/**
 * Created by marcus on 17/3/27.
 */
public class FileUtils {

    public static final String readFileContent(String filePatch){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePatch)));
            StringBuffer stringBuffer = new StringBuffer();
            String data = null;
            while((data = br.readLine())!=null)
            {
                stringBuffer.append(data);
                stringBuffer.append("\n");
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final void writeContextToFile(String content, String outputFilePatch){
        File f=new File(outputFilePatch);
        FileWriter fw=null;
        BufferedWriter bw=null;
        try{
            if(!f.exists()){
                f.createNewFile();
            }
            fw = new FileWriter(f.getAbsoluteFile(),false);  //true表示可以追加新内容
            //fw=new FileWriter(f.getAbsoluteFile()); //表示不追加
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
