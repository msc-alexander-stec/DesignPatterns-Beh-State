package pkg.state.concr;
import pkg.context.Context;
import pkg.state.abstr.State;

public class StateHasPin implements State {

	Context atmMachine;

	//
	// Constructor
	//

	public StateHasPin(Context newATMMachine) {
		atmMachine = newATMMachine;
	}

	//
	// Interface implementation
	//

	public void edgeInsertCard() {
		System.out.println("You already entered a card");
	}

	public void edgeEjectCard() {
		System.out.println("Your card is ejected");
		atmMachine.setATMState(atmMachine.getStateToNoCard());
	}

	public void edgeRequestCash(int cashToWithdraw) {

		if (cashToWithdraw > atmMachine.cashInMachine) {

			System.out.println("You don't have that much cash available");
			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getStateToNoCard());

		} else {

			System.out.println(cashToWithdraw + " is provided by the machine");
			atmMachine.setCashInMachine(atmMachine.cashInMachine
					- cashToWithdraw);

			System.out.println("Your card is ejected");
			atmMachine.setATMState(atmMachine.getStateToNoCard());

			if (atmMachine.cashInMachine <= 0) {

				atmMachine.setATMState(atmMachine.getStateToAtmOutOfMoney());

			}
		}
	}

	public void edgeInsertPin(int pinEntered) {

		System.out.println("You already entered a PIN");

	}
}