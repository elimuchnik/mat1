package mat1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;
import java.util.StringTokenizer;

public class My_Test {
	String[] arr;

	public void paste_test(String data_path, String BL_path) {
		try {
			Graph_algo a = new Graph_algo(data_path);

			FileReader fr = new FileReader(BL_path);
			BufferedReader br = new BufferedReader(fr);
			int num = Integer.parseInt(br.readLine());
			arr = new String[num + 1];
			arr[0] = "" + num;
			int begin;
			int end;
			int num_black;
			// int[]array;
			for (int i = 1; i <= num; i++) {
				String str = br.readLine();
				StringTokenizer stk = new StringTokenizer(str);
				begin = Integer.parseInt(stk.nextToken());
				end = Integer.parseInt(stk.nextToken());
				num_black = Integer.parseInt(stk.nextToken());
				int[] array = new int[num_black];
				if (num_black > 0) {
					for (int j = 0; j < array.length; j++) {
						array[j] = Integer.parseInt(stk.nextToken());
						// System.out.println(array[j]);
					}
					double ans = a.distanse(begin, end, array);
					if (ans == -1)
						arr[i] = str + "there is no path";
					else
						arr[i] = str + " " + ans;
				} else {
					double ans = a.distanse(begin, end);
					if (ans == -1)
						arr[i] = str + "there is no path";
					else
						arr[i] = str + " " + ans;
				}
			}
			br.close();
			// FileWriter fw =new FileWriter("answer.txt");
			// PrintWriter outs =new PrintWriter(fw);
			// for (int i = 0; i < arr.length; i++) {
			// outs.println(arr[i]);
			// }
			// outs.close();
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (IOException ex) {
			System.out.println("error\n" + ex);

		}
		try {
			FileWriter fw = new FileWriter("answer.txt");
			PrintWriter outs = new PrintWriter(fw);
			for (int i = 0; i < arr.length; i++) {
				outs.println(arr[i]);
			}
			outs.close();

		} catch (IOException ex) {
			System.out.println("error\n" + ex);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My_Test a = new My_Test();
		a.paste_test("largeEWD.txt", "test3.txt");
	}

}
