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
public class GetSavedGamesMessage implements Serializable {

	private static final long serialVersionUID = 2854472421280126218L;

	public final int senderID; // The ID of the client who sent that message.
	public final Object message; // Original message from a client.

	/**
	 * Create a ForwadedMessage to wrap a message sent by a client.
	 * 
	 * @param senderID
	 *            the ID number of the original sender.
	 * @param usuario
	 *            El usuario del cual se quieren mostrar los juegos.
	 */
	public GetSavedGamesMessage(int senderID, Object message) {
		this.senderID = senderID;
		this.message = message;
	}
}
