package Basic.AlgorithmBasic.Heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskContoroller_rereTry {

	public static void main(String[] args) {


		int[][] jobs = {
				{0,3} , {1,9} , {2,6}
		};

		int result = solution(jobs);
		System.out.println(" result : " + result );

	}

	public static int solution(int[][] jobs) {

		Arrays.sort(jobs, (o1,o2)->{
			int result =o1[0]-o2[0];
			if ( result==0 ) return o1[1]-o2[1];
			return result;
		});

		int result = 0;

		// 처리대상 데이터를 진입순서대로 정렬 된 상태로 Queue에 보관.
		Queue<int[]> jobData = new LinkedList<>();

		for( int[] job : jobs ) {
			jobData.add(job);
		}

		// 소요시간이 빠른게 먼저 처리 될 수 있는 데이터 보관하기
		PriorityQueue<Process> pq = new PriorityQueue<>();

		// 초기 값
		int[] start = jobData.poll();
		pq.add(new Process(start[0],start[1]));

		// 최초 시작 타임은, 첫번째 프로세스가 들어오는 시간이 된다.
		int totalT = pq.peek().inTime;

		//최초, pq에 넣을 수 있는대상 모두 넣어주기.
		while( !jobData.isEmpty() && jobData.peek()[0] <= totalT  ) {
			int[] temp = jobData.poll();
			pq.add(new Process(temp[0],temp[1]));
		}

		// 남아있는 프로세스 모두 처리하기.
		while ( !pq.isEmpty() ) {

			int resultT = 0 ;

			Process p = pq.poll();

			totalT += p.wkT;

			resultT = totalT - p.inTime;
			result += resultT;

			//pq에 넣을 수 있는대상 모두 넣어주기.
			while( !jobData.isEmpty() && jobData.peek()[0] <= totalT  ) {
				int[] temp = jobData.poll();
				pq.add(new Process(temp[0],temp[1]));
			}

			// totalT보다 <=경우에 걸리지 않은 경우.
			if( pq.isEmpty() && !jobData.isEmpty() ) {

				// 초기 값
				start = jobData.poll();
				pq.add(new Process(start[0],start[1]));

				totalT = pq.peek().inTime;

				while( !jobData.isEmpty() && jobData.peek()[0] <= totalT  ) {
					int[] temp = jobData.poll();
					pq.add(new Process(temp[0],temp[1]));
				}
			}
		}
		return result/jobs.length;
	}

	// 진입, 처리시간을 정렬할 수 있는 Clas 선언
	static class Process implements Comparable<Process> {

		int inTime ;
		int wkT ;

		Process(int inTime , int wkT ){
			this.inTime = inTime;
			this.wkT = wkT;
		}

		@Override
		public int compareTo(Process o) {
			return wkT-o.wkT;
		}

		@Override
		public String toString() {
			return "Process [inTime=" + inTime + ", wkT=" + wkT + "]";
		}

	}

}
