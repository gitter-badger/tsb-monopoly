
/**
 * 
 */
package monopoly.util.message;

import java.io.Serializable;

/**
 * @author Bostico Alejandro
 * @author Moreno Pablo
 *
 */
public class CreateAccountMessage implements Serializable {

	private static final long serialVersionUID = -835479036373118920L;

	public final Object message; // Original message from a client.
	public final int senderID; // The ID of the client who sent that message.

	/**
	 * Create a ForwadedMessage to wrap a message sent by a client.
	 * 
	 * @param senderID
	 *            the ID number of the original sender.
	 * @param message
	 *            the original message.
	 */
	public CreateAccountMessage(int senderID, Object message) {
		this.senderID = senderID;
		this.message = message;
	}

}
