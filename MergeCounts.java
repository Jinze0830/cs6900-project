import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeCounts {
	public ArrayList<String> readTxt(String Path) throws IOException{
		
            File file=new File(Path);
            ArrayList<String> list=new ArrayList<String>();
            if(file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                String[] newLine;
                //ArrayList<String> list=new ArrayList<String>();
                while((lineTxt = bufferedReader.readLine()) != null){
                	newLine=lineTxt.split(",");
                    list.add(newLine[0]);
                }
                read.close();
         }else{
        	 System.out.println("file not found");
         }
         return list;
 
	}
	public static void main(String arg[]) throws IOException{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String context;
		String nContext;
		
		int wordNum=0;
		String key;
		
		MergeCounts mc = new MergeCounts();
		//ArrayList<String> amc=mc.readTxt("Desktop:\\wordInfo.txt");
		
		//BufferedReader br = new BufferedReader(new FileReader("wordInfo.txt"));
		while((context = f.readLine()) != null){
			boolean flag=true;
			int uNum = 0;
			ArrayList<String> amc=mc.readTxt("Desktop:\\wordInfo.txt");
			for(int i=0;i<amc.size();i++){
				if(amc.get(i).equals(context)){
					flag=false;
					break;
				}
			}
			
			int words=1;
			wordNum++;
			if(flag){
				uNum++;
				File file = new File("Desktop:\\wordInfo.txt");
				String str;
				while((nContext = f.readLine()) != null){
					if(nContext.equals(context)){
						words++;
					}
				}
				FileWriter writer = new FileWriter(file);
				str=f.readLine()+","+words;
				writer.write(str);
				writer.flush();
				writer.close();
			}
		}
	}
}

