/**
 * 
 */
package monopoly.util.message.game;

import java.io.Serializable;

/**
 * @author Bostico Alejandro
 * @author Moreno Pablo
 *
 */
public class LoadGameMessage implements Serializable {

	private static final long serialVersionUID = -9074283536571385267L;

	public final Object message; // Original message from a client.
	public final int senderID; // The ID of the client who sent that message.

	/**
	 * Create a ForwadedMessage to wrap a message sent by a client.
	 * 
	 * @param senderID
	 *            the ID number of the original sender.
	 * @param juego
	 *            el juego que se quiere restaurar.
	 */
	public LoadGameMessage(int senderID, Object juego) {
		this.senderID = senderID;
		this.message = juego;
	}
}
