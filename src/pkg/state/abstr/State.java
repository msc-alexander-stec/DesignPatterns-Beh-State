package pkg.state.abstr;
public interface State {

	void edgeInsertCard();

	void edgeEjectCard();

	void edgeInsertPin(int pinEntered);

	void edgeRequestCash(int cashToWithdraw);

}
