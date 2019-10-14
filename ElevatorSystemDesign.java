/*
Elevator System Design
We wish to simulate an elevator in a building with floors numbered 1 to a parameter N, inclusive. If N is 10, for example, we create our elevator simulator with a statement of the form
Elevator e = new Elevator(10);

At any given time, we can inquire as to the current floor with the expression
e.floor();

At any given time, the elevator has a current direction (up or down) and there may be outstanding requests to stop at various floors. Initially, e.floor() is 1, there are no requests, and the current direction is up. The elevator accepts floor requests when it is stopped. The call
e.request(F); adds a request to stop at floor F, which must be between 1 and N, inclusive; it does nothing if there is already such a request or it is already stopped at floor F. 

In response to the method call e.move() the elevator moves to the nearest requested floor in its current direction, if any. If there are no more requested floors in that direction, but there are floors in the other direction, it first reverses the current direction and then goes to the nearest requested floor. If there are no outstanding requests, a call to .move has no effect.
Implement the Elevator class on the next page. It must implement an appropriate constructor and the public methods should be floor, request, and move. Somewhat unrealistically, assume the elevator can have a very large number of floors and receive very large numbers of requests.
*/

import java.util.PriorityQueue;
import static java.util.Collections.reverseOrder;

public class Elevator {
	private int _N;
	private boolean _up;
	private int _floor;
	private PriorityQueue<Integer> _upQueue = new PriorityQueue<>();
	private PriorityQueue<Integer> _downQueue = new PriorityQueue<>(<Integer> reverseOrder());

	public Elevator (int N) {
		_N = N;
		_up = true;
		_floor = 1;
	}

	public int floor() {
		return _floor;
	}

	public void request(int floor) {
		if (_upQueue.contains(floor) || _downQueue.contains(floor)) {
			return;
		}

		if (floor > _floor) {
			_upQueue.add(floor);
		} else if (floor < _floor) {
			_downQueue.add(floor);
		}
	}

	public void move() {
		if (_upQueue.isEmpty() && _downQueue.isEmpty()) {
			return;
		} else if (_up && _upQueue.isEmpty() || !_up && _downQueue.isEmpty()) {
			_up = !_up;
		}

		if (_up) {
			_floor = _upQueue.poll();
		} else {
			_floor = _downQueue.poll();
		}
	}
}