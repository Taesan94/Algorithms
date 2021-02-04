package Basic.AlgorithmBasic.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {

	public static void main(String[] args) {

		int[][] jobs = {
				// {2,6},{0,3},{1,9}
				// {1,3}, {5,6}
				// {1,2} , {1,3} ,{1,100}, {1,5} , {1,4}
				// {0,3},{4,3},{10,3}
				// {0,3},{0,1},{4,7}
				// {0,5},{1,2},{5,5}
				// {0,3},{4,3},{10,3}
				// {0,10},{2,3},{9,3}
				// {1,10},{3,3},{10,3}
				// {0,10}
				// {0,10},{4,10},{5,11},{15,2}
				// {0,1},{15,2}
				// {0,9},{0,4},{0,5},{0,7},{0,3}
				// {1,9},{1,4},{1,5},{1,7},{1,3}
				// {0,3},{1,9},{2,6},{30,3}
				// {0,3},{1,9},{500,6}
				//{24, 10}, {18, 39}, {34, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}
				//{0,3},{1,9},{2,6},{4,3}
				{0,6},{0,8},{7,1}
		};

		int result = solution(jobs);

		System.out.println(" result : " + result);

	}

	public static int solution(int[][] jobs) {

		// 먼저 들어온 순서대로 입력값을 정렬해준다.
		Arrays.sort(jobs,(o1,o2)->{
			return o1[0]-o2[0];
		});

		PriorityQueue<Process> pq = new PriorityQueue<>();

		// 최초 시간은 가장적은 대기시간 프로세스의 시작시간이다.
		int sum = 0 ; // 총 소요시간을 기록한다.
		int time = jobs[0][0] ; // 걸린시간.

		// 모든 process를 처리하면서,하나의 프로세스가 끝났을 때 다음으로 처리 될 수 있는 프로세스들을add 한다.
		for( int i=0; i<jobs.length; i++ ) {

			int[] job = jobs[i];

			// 현재 소요시간보다 다음 작업의 출발시간이 클 때, PriorityQueue에 작업이 남아 있으면, 
			// 다음 작업보다 작거나 같을 때 까지는 작업을 처리해도 된다.
			if( job[0] > time ) {
				if ( pq.isEmpty() ) time = job[0];
				else {
					while( !pq.isEmpty() ) {
						Process p = pq.poll();
						time += p.working;
						sum += time-p.start;
						// 다음 작업을 넣어도, 우선순위대로 처리 될 수 있을 때 break해준다.
						if ( time > job[0] ) break;
					}
				}
			}

			int index = i;

			boolean visit = false;

			// 현재시간에 처리가능한 대상을 모두 넣어주기.
			while( index < jobs.length && jobs[index][0] <= time ) {
				pq.add(new Process(jobs[index][0],jobs[index][1]));
				index++;
				visit =true;
			}

			if(visit) i=index-1;

			System.out.println(" 처리 할 수 있는 놈들 " + pq.toString());

			Process p = pq.poll();

			System.out.println(p.toString());

			time += p.working;
			sum += time-p.start;

			System.out.println(" time : " + time +" , sum : " + sum +", 소요시간 : "+(time-p.start));

		}

		while( !pq.isEmpty() ) {
			Process p = pq.poll();

			if(p.start > time) time= p.start;
			System.out.println("###" + p.toString());
			time += p.working;
			sum += time-p.start;
		}

		return sum/jobs.length;
	}

	static class Process implements Comparable<Process>{

		int start ;
		int working;

		Process(int start, int working){
			this.start=start;
			this.working=working;
		}

		@Override
		public int compareTo(Process o) {
			int value = working-o.working;
			if(value==0) value = start-o.start;
			return value;
		}

		@Override
		public String toString() {
			return "Process [start=" + start + ", working=" + working + "]";
		}
	}

}
