package com.codeChefMedium.Greedy.IntervalScheduling;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class One_DimensionalKingdom {
	

//1) take the first two number. save the two numbers as a1 and a2.
//2) Save this first two number as p1 and p2 in res-set 1.
//2) Find the mid point a1+a2/2 as the bombing point
//3) Take the next two numbers b1 and b2
//4) for(each val in res set) take p1 and p2 as a1 and a2
//4) if(a2>b1 && b2>a1)
//5) if(b1>a1) p1=b1 else p1=a1
//6)if(b2>a2) p2=a2 else p2=b2
//7) replace set1 with p1 and p2
//8) else save b1 and b2 as res-set 2
//9) go to step 3
	
	public static void main(String args[]) {
		InputReader in = new InputReader(System.in);		 
		OutputWriter st = new OutputWriter(System.out);		 
		int i,j,t = in.readInt();
		while(t-->0)
		{
			int n=in.readInt();
			int min[]=new int[2003];
			for(i=0;i<=2002;i++)
				min[i]=10000;
			int sum=0;
		 
			while(n-->0)
			{
				int x=in.readInt();
				int y=in.readInt();
				min[x]=min[x]>y?y:min[x];
			}
		 
			i=0;j=min[0];
			while(i<=2001)
			{
				if(i==j)
				{
					sum++;
					j=min[i+1];
				}
				else
					j=j>min[i]?min[i]:j;
					if(i==j)
					{
						sum++;
						j=min[i+1];
					}
		 
					i++;
			}
			st.printLine(sum);
		 
		}
		st.close();
	}
}
class InputReader {		 
		private InputStream stream;		 
		private byte[] buf = new byte[1024];		 
		private int curChar;		 
		private int numChars;		 
		private SpaceCharFilter filter;		 
		public InputReader(InputStream stream) {		 
		this.stream = stream;		 
		}
		 
		public int read() {	 
			if (numChars == -1) {
				throw new InputMismatchException();
			}
		 
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
		 
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		 
		}
		 
		public int readInt() {		 
		int c = read();		 
		while (isSpaceChar(c)) {
			c = read();
		}		 
		int sgn = 1;		 
		if (c == '-') {		 
		sgn = -1;		 
		c = read();		 
		}		 
		int res = 0;		 
		do {		 
		if (c < '0' || c > '9') {
		throw new InputMismatchException();
		}
		res *= 10;
		res += c - '0';
		c = read();		 
		} while (!isSpaceChar(c));
		return res * sgn;
		}
		 
		public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
		c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
		res.appendCodePoint(c);
		c = read();
		} while (!isSpaceChar(c));
		return res.toString();
		}
		 
		public double readDouble() {
		int c = read();
		while (isSpaceChar(c)) {
		c = read();
		}
		int sgn = 1;
		if (c == '-') {
		sgn = -1;
		c = read();
		}
		double res = 0;
		while (!isSpaceChar(c) && c != '.') {
		if (c == 'e' || c == 'E') {
		return res * Math.pow(10, readInt());
		}
		if (c < '0' || c > '9') {
		throw new InputMismatchException();
		}
		res *= 10;
		res += c - '0';
		c = read();
		}
		if (c == '.') {
		c = read();
		double m = 1;
		while (!isSpaceChar(c)) {
		if (c == 'e' || c == 'E') {
		return res * Math.pow(10, readInt());
		}
		if (c < '0' || c > '9') {
		throw new InputMismatchException();
		}
		m /= 10;
		res += (c - '0') * m;
		c = read();
		}
		}
		return res * sgn;
		}
		 
		public long readLong() {
		int c = read();
		while (isSpaceChar(c)) {
		c = read();
		}
		int sgn = 1;
		if (c == '-') {
		sgn = -1;
		c = read();
		}
		long res = 0;
		do {
		if (c < '0' || c > '9') {
		throw new InputMismatchException();
		}
		res *= 10;
		res += c - '0';
		c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
		}
		 
		public boolean isSpaceChar(int c) {		 
		if (filter != null) {
		return filter.isSpaceChar(c);
		}		 
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
		 
		public String next() {		 
		return readString();
		}
		 
		public interface SpaceCharFilter {		 
		public boolean isSpaceChar(int ch);		 
		}
		 
}
		 
		class OutputWriter {		 
		private final PrintWriter writer;		 
		public OutputWriter(OutputStream outputStream) {		 
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}
		 
		public OutputWriter(Writer writer) {		 
		this.writer = new PrintWriter(writer);
		}
		 
		public void print(Object... objects) {		 
		for (int i = 0; i < objects.length; i++) {		 
		if (i != 0) {
		writer.print(' ');
		}
		writer.print(objects[i]);		 
		}		 
		}
		 
		public void printLine(Object... objects) {		 
		print(objects);		 
		writer.println();		 
		}
		 
		public void close() {		 
		writer.close();		 
		}
		 
		public void flush() {		 
		writer.flush();		 
		}


}
