package LottoGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//돈 넣기
		int money;
		Scanner sc=new Scanner(System.in);
		System.out.print("로또를 구입할 금액을 입력하세요:");
		try {
			money=Integer.parseInt(sc.nextLine());
			if (money<1000) { //금액이 1000원 미만일
				System.out.println("[ERROR] 금액이 부족합니다.");
				return; //돌아가기 
			}
			if (money%1000!=0)
			{
				System.out.println("[ERROR] 금액이 나누어떨어지지않습니다.");
				return; //돌아가기
			}
			System.out.print("\n당첨 번호 6개를 다음 양식으로 입력해주세요\n0,0,0,0,0,0:");
			
			String line=sc.nextLine();
			String []winArray=line.split(",");
			Set<Integer> winLotto=new TreeSet<Integer>();
			for(int i=0; i<winArray.length; i++)
			{
				int j=Integer.parseInt(winArray[i]);
				if(j<0||j>45) {
					System.out.println("[ERROR] 로또번호는 1부터 45사이의 숫자여야합니다.");
					return;
				}
				winLotto.add(j);
			}
			if(winLotto.size()!=6) {
				System.out.println("[ERROR] 중복된 숫자가 있습니다.");
				return;
			}
			System.out.print("보너스 번호를 입력해주세요:");
			int bonus=Integer.parseInt(sc.nextLine());

			
			int count = money/1000;
			int []winCount = new int[count];
			System.out.println("\n["+count+"개의 로또를 구매했습니다.]");
			List<List<Integer>> setLottoList = new ArrayList<List<Integer>>();
			for (int i=0; i<count; i++)//로또갯수만큼포문
			{
				Set<Integer> setLotto=new TreeSet<Integer>();//샛컬렉션활용
				while(true)//로또안에난수입력
				{
					int n=(int)(Math.random()*45)+1;//난수생성 
					setLotto.add(n);//난수입력 
					if(setLotto.size()==6)//난수여섯개되면 
						break;//종료
				}
				
				List<Integer> arr = new ArrayList<>(setLotto);
				setLottoList.add(arr);
			}
			
			Iterator<List<Integer>> iter = setLottoList.iterator();
			while(iter.hasNext()) {
				System.out.println(" ====== : " + iter.next());
			}
			
			iterateUsingIterator(setLottoList);
			
			
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 숫자가 아닙니다.");
		}
				
	}
	
	  public static <K> void
	    iterateUsingIterator(List<List<K> > listOfLists)
	    {
	        // Iterator for the 2D list
	        Iterator listOfListsIterator
	            = listOfLists.iterator();
	  
	        System.out.println("[");
	        while (listOfListsIterator.hasNext()) {
	  
	            // Type cast next() method
	            // to convert from Object to List<K>
	            List<K> list = new ArrayList<K>();
	  
	            list = (List<K>)listOfListsIterator.next();
	  
	            // Iterator for list
	            Iterator eachListIterator
	                = list.iterator();
	            System.out.println("[ ");
	            while (eachListIterator.hasNext()) {
	                System.out.print(eachListIterator.next() + " ");
	            }
	            System.out.println("], ");
	        }
	        System.out.println("]");
	    }
}
