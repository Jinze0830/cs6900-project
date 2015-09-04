import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NBTrain {
	public HashSet<String> grepLabels(String x){
		String cLabel;
		HashSet<String> h = new HashSet();
		   //ArrayList<String> check= tokenizeDoc(x);
		String[] label = x.split("\t");
		cLabel=label[0];
		String[] labels=cLabel.split("\\s+");
		Pattern p=Pattern.compile(".+CAT");
		for(int i=0;i<labels.length;i++){
			Matcher matcher = p.matcher(labels[i]);
			if(matcher.find()){
				h.add(labels[i]);
			}
		}
		return h;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String x = null;
		
		NBTrain train=new NBTrain();
		HashSet<String> s=new HashSet<String>();
		Iterator it=s.iterator();
		while( (x = f.readLine()) != null )
		{	
			if(x.matches("\t")){
			   // HashSet<String> s=new HashSet<String>();
			    //Iterator it=s.iterator();
			    s=train.grepLabels(x);
			    String[] sen=x.split("\t");
			    String[] context=sen[1].split("\\s+");
			    for(int i=0;i<context.length;i++){
					   while(it.hasNext()){
						   System.out.println(context[i]+"\t"+it.next());
					   }
				    }
			    
			}
			while(!x.matches("\t")){
				//Iterator it=s.iterator();
				String[] sen=x.split("\t");
			    String[] context=sen[1].split("\\s+");
				for(int i=0;i<context.length;i++){
				   while(it.hasNext()){
					   System.out.println(context[i]+"\t"+it.next());
				   }
			    }
			}
		}
	}

}
