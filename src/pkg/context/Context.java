package pkg.context;

import pkg.state.abstr.State;
import pkg.state.concr.StateHasCard;
import pkg.state.concr.StateHasPin;
import pkg.state.concr.StateNoCard;
import pkg.state.concr.StateNoCash;

// Context
public class Context {

	// Edges (Transitions) from one state to the other state
	State cardInserted;
	State noCard;
	State pinInserted;
	State atmOutOfMoney;

	// Current state
	State currentState;

	public int cashInMachine = 2000;
	public boolean correctPinEntered = false;

	//
	// Constructor
	//

	public Context() {
		cardInserted = new StateHasCard(this);
		noCard = new StateNoCard(this);
		pinInserted = new StateHasPin(this);
		atmOutOfMoney = new StateNoCash(this);

		// Set init state
		currentState = noCard;

		if (cashInMachine < 0) {
			currentState = atmOutOfMoney;
		}

	}

	//
	//
	//

	public void setATMState(State newATMState) {
		currentState = newATMState;
	}

	public void setCashInMachine(int newCashInMachine) {
		cashInMachine = newCashInMachine;
	}

	//
	// Change state
	//

	public State getStateToHasCard() {
		return cardInserted;
	}

	public State getStateToNoCard() {
		return noCard;
	}

	public State getStateToPinInserted() {
		return pinInserted;
	}

	public State getStateToAtmOutOfMoney() {
		return atmOutOfMoney;
	}

	//
	// Client executes this methods
	//

	public void executeInsertCard() {
		currentState.edgeInsertCard();
	}

	public void executeEjectCard() {
		currentState.edgeEjectCard();
	}

	public void executeRequestCash(int cashToWithdraw) {
		currentState.edgeRequestCash(cashToWithdraw);
	}

	public void executeInsertPin(int pinEntered) {
		currentState.edgeInsertPin(pinEntered);
	}

}
