package pkg.state.concr;
import pkg.context.Context;
import pkg.state.abstr.State;

public class StateHasCard implements State {

	Context atmMachine;

	//
	// Constructor
	//

	public StateHasCard(Context newATMMachine) {
		atmMachine = newATMMachine;
	}

	//
	// Interface implementation
	//

	public void edgeInsertCard() {
		System.out.println("You can only insert one card at a time");
	}

	public void edgeEjectCard() {
		System.out.println("Your card is ejected");
		atmMachine.setATMState(atmMachine.getStateToNoCard());
	}

	public void edgeRequestCash(int cashToWithdraw) {
		System.out.println("You have not entered your PIN");
	}

	public void edgeInsertPin(int pinEntered) {
		if (pinEntered == 1234) {

			System.out.println("You entered the correct PIN");
			atmMachine.correctPinEntered = true;
			atmMachine.setATMState(atmMachine.getStateToPinInserted());

		} else {

			System.out.println("You entered the wrong PIN");
			atmMachine.correctPinEntered = false;
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getStateToNoCard());

		}
	}
}