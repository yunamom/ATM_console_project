package view;

import java.io.*;

public class FileWrite {
	
	public static void main(String[] args) {
		
		
		try (
				/*	이곳에 객체를 생성하면 try 종료 후 자동으로 close 처리가 됩니다.
				 *  true : 기존 파일에 이어서 작성 (default는 false 입니다.) - 덮어씌기가 됨
				 */
				FileWriter f_writer = new FileWriter("test.txt");
				BufferedWriter b_writer = new BufferedWriter( f_writer );
				
				)
		{
				b_writer.newLine(); // 버퍼에 개행 삽입 Enter
				b_writer.write("  	┏━━━* I Love U ━━━┓"); //버터에 입력
				b_writer.newLine(); // 버퍼에 개행 삽입
				b_writer.write("  	┃                 ┃");
				b_writer.newLine();
				b_writer.write("  	┃  Lovely yuna *  ┃");
				b_writer.newLine();
				b_writer.write("  	┃                 ┃");
				b_writer.newLine();
				b_writer.write("  	┗━━━━━━━━━━━━━━━━━┛");
				b_writer.newLine();
				b_writer.newLine();			
				b_writer.flush(); //버퍼의 내용을 파일에 쓰기
			
		} catch ( IOException e) {
			System.out.println(e);
		}
		
		File file = new File("test.txt");
		// 파일 유/무 판단 
		if (file.isFile()) {
			System.out.println("test.txt 파일이 있습니다.");
		}
		
	// 1. FileReader
		
		try(
				/*	이곳에 객체를 생성하면 try 종료 후 자동으로 close 처리가 됩니다.
				 */
				FileReader reader = new FileReader("test.txt");
				)
		{
			
			int check;
			
			while((check = reader.read()) != -1) {
				System.out.print((char)check);
			}
			
		}catch ( IOException e ) {
			System.out.println(e);
		}
	}
}
