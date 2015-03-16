package test.client;
import pkg.context.Context;

public class TestClient {

	public static void main(String[] args) {

		Context atmMachine = new Context();

		atmMachine.executeInsertCard();

		atmMachine.executeEjectCard();

		atmMachine.executeInsertCard();

		atmMachine.executeInsertPin(1234);

		atmMachine.executeRequestCash(2000);

		atmMachine.executeInsertCard();

		atmMachine.executeInsertPin(1234);

	}

}
