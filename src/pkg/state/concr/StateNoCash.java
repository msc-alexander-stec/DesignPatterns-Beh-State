package pkg.state.concr;
import pkg.context.Context;
import pkg.state.abstr.State;

public class StateNoCash implements State {

	Context atmMachine;

	public StateNoCash(Context newATMMachine) {

		atmMachine = newATMMachine;

	}

	public void edgeInsertCard() {

		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");

	}

	public void edgeEjectCard() {

		System.out.println("We don't have any money");
		System.out.println("There is no card to eject");

	}

	public void edgeRequestCash(int cashToWithdraw) {

		System.out.println("We don't have any money");

	}

	public void edgeInsertPin(int pinEntered) {

		System.out.println("We don't have any money");

	}
}