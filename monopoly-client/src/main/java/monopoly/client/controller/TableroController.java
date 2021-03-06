/**
 * 
 */
package monopoly.client.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import monopoly.client.connection.ConnectionController;
import monopoly.client.controller.TirarDadosController.TipoTiradaEnum;
import monopoly.client.util.FXUtils;
import monopoly.client.util.ScreensFramework;
import monopoly.model.AccionEnCasillero;
import monopoly.model.Banco;
import monopoly.model.Deuda;
import monopoly.model.History;
import monopoly.model.Juego;
import monopoly.model.Jugador;
import monopoly.model.MonopolyGameStatus;
import monopoly.model.Usuario;
import monopoly.model.tablero.Casillero;
import monopoly.model.tablero.CasilleroCalle;
import monopoly.model.tablero.CasilleroCompania;
import monopoly.model.tablero.CasilleroEstacion;
import monopoly.model.tarjetas.Tarjeta;
import monopoly.model.tarjetas.TarjetaCalle;
import monopoly.model.tarjetas.TarjetaCompania;
import monopoly.model.tarjetas.TarjetaComunidad;
import monopoly.model.tarjetas.TarjetaPropiedad;
import monopoly.model.tarjetas.TarjetaSuerte;
import monopoly.util.GestorLogs;
import monopoly.util.StringUtils;
import monopoly.util.constantes.ConstantesFXML;
import monopoly.util.constantes.EnumSalidaCarcel;
import monopoly.util.constantes.EnumsTipoImpuesto;
import monopoly.util.exception.CondicionInvalidaException;
import monopoly.util.message.game.ChatGameMessage;
import monopoly.util.message.game.CompleteTurnMessage;
import monopoly.util.message.game.GetMortgagesMessage;
import monopoly.util.message.game.SaveGameMessage;
import monopoly.util.message.game.actions.GoToJailMessage;
import monopoly.util.message.game.actions.PayRentMessage;
import monopoly.util.message.game.actions.PayToBankMessage;
import monopoly.util.message.game.actions.PayToLeaveJailMessage;
import monopoly.util.message.game.actions.SuperTaxMessage;

/**
 * @author Bostico Alejandro
 * @author Moreno Pablo
 *
 */
public class TableroController extends AnchorPane implements Serializable,
		Initializable {

	private static final long serialVersionUID = 2964193640386734389L;

	@FXML
	private BorderPane pTablero;

	@FXML
	private TilePane pCasillero01;

	@FXML
	private TilePane pCasillero02;

	@FXML
	private TilePane pCasillero03;

	@FXML
	private TilePane pCasillero04;

	@FXML
	private TilePane pCasillero05;

	@FXML
	private TilePane pCasillero06;

	@FXML
	private TilePane pCasillero07;

	@FXML
	private TilePane pCasillero08;

	@FXML
	private TilePane pCasillero09;

	@FXML
	private TilePane pCasillero10;

	@FXML
	private TilePane pCasillero11;

	@FXML
	private TilePane pCasillero12;

	@FXML
	private TilePane pCasillero13;

	@FXML
	private TilePane pCasillero14;

	@FXML
	private TilePane pCasillero15;

	@FXML
	private TilePane pCasillero16;

	@FXML
	private TilePane pCasillero17;

	@FXML
	private TilePane pCasillero18;

	@FXML
	private TilePane pCasillero19;

	@FXML
	private TilePane pCasillero20;

	@FXML
	private TilePane pCasillero21;

	@FXML
	private TilePane pCasillero22;

	@FXML
	private TilePane pCasillero23;

	@FXML
	private TilePane pCasillero24;

	@FXML
	private TilePane pCasillero25;

	@FXML
	private TilePane pCasillero26;

	@FXML
	private TilePane pCasillero27;

	@FXML
	private TilePane pCasillero28;

	@FXML
	private TilePane pCasillero29;

	@FXML
	private TilePane pCasillero30;

	@FXML
	private TilePane pCasillero31;

	@FXML
	private TilePane pCasillero32;

	@FXML
	private TilePane pCasillero33;

	@FXML
	private TilePane pCasillero34;

	@FXML
	private TilePane pCasillero35;

	@FXML
	private TilePane pCasillero36;

	@FXML
	private TilePane pCasillero37;

	@FXML
	private TilePane pCasillero38;

	@FXML
	private TilePane pCasillero39;

	@FXML
	private TilePane pCasillero40;

	@FXML
	private TextArea txtMessageChat;

	@FXML
	private Accordion accordionPlayers;

	@FXML
	private Accordion accordionHistorial;

	@FXML
	private TitledPane tpHistory;

	@FXML
	private TitledPane tpChat;

	@FXML
	private Label lblStopwatch;

	@FXML
	private MenuButton btnMenu;

	@FXML
	private MenuButton btnAcciones;

	@FXML
	private MenuItem btnHipotecar;

	@FXML
	private MenuItem btnVender;

	@FXML
	private MenuItem btnDeshipotecar;

	@FXML
	private MenuItem btnComercializar;

	@FXML
	private MenuItem btnConstruir;

	@FXML
	private MenuItem btnBancarrota;

	@FXML
	private ListView<History> lvHistoryChat;
	private static List<History> historyChatList;
	private ObservableList<History> oHistoryChatList;

	@FXML
	private ListView<History> lvHistoryGame;
	private static List<History> historyGameList;
	private ObservableList<History> oHistoryGameList;

	@FXML
	private HBox hboxTurnoDados;

	@FXML
	private ImageView imgDados;

	@FXML
	private Label lblTurnoJugador;

	@FXML
	private Button btnFinalizarTurno;

	@FXML
	private Button btnTirarDados;

	private static TableroController instance;

	@FXML
	private Stage currentStage;

	@FXML
	private Stage prevStage;

	@FXML
	private Stage preloaderStage;

	@FXML
	private TitledPane[] tps;

	private Juego juego;

	private Usuario usuarioLogueado;

	private static MonopolyGameStatus estadoActual;

	private StringProperty clockLabelTextProperty;

	private Deuda deudaPendiente;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		instance = this;
		// lvHistoryGame = new ListView<History>();

		historyGameList = new ArrayList<History>();
		historyChatList = new ArrayList<History>();
		oHistoryGameList = FXCollections.observableArrayList(historyGameList);
		oHistoryChatList = FXCollections.observableArrayList(historyChatList);
		accordionHistorial.setExpandedPane(tpHistory);

		txtMessageChat.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER) {
					if (txtMessageChat.getText().trim().length() == 0) {
						keyEvent.consume();
					} else {
						if (keyEvent.isAltDown() || keyEvent.isControlDown()
								|| keyEvent.isShiftDown()) {
							txtMessageChat.appendText("\n");
						} else {
							sendChatMessage();
							keyEvent.consume();
						}

					}
				}
			}
		});
	}

	/**
	 * 
	 * Éste método muestra el tablero y muestra un messagebox informando al
	 * jugador que debe esperar a que se unan al juego otros oponentes.
	 * 
	 */
	public void showTableroDeJuego() {
		loadStage();
		this.clockLabelTextProperty = lblStopwatch.textProperty();

		createDigitalClock();
		if (usuarioLogueado.equals(juego.getOwner()))
			addHistoryGame(usuarioLogueado.getUserName(), "Creó el juego.");
		else
			addHistoryGame(usuarioLogueado.getUserName(), "Sé unió al Juego.");

		esperarJugadores();
	}

	/**
	 * 
	 * Éste método muestra el tablero y muestra un messagebox informando al
	 * jugador que debe esperar a que se unan al juego otros oponentes.
	 * 
	 */
	public void restaurarJuego(MonopolyGameStatus monopolyGameStatus)
			throws Exception {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				loadStage();
				clockLabelTextProperty = lblStopwatch.textProperty();
				createDigitalClock();
			}
		});

		this.actualizarEstadoJuego(monopolyGameStatus);

	}

	private Stage loadStage() {
		// currentStage.setFullScreen(true);
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		currentStage.setX(bounds.getMinX());
		currentStage.setY(bounds.getMinY());
		currentStage.setWidth(bounds.getWidth());
		currentStage.setHeight(bounds.getHeight());
		currentStage.show();
		prevStage.close(); // cierra la ventana de restauración
		MenuOpcionesController.getInstance().getCurrentStage().hide(); // oculta
																		// el
																		// menú
		currentStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				cerrar(false);
				we.consume();
			}
		});

		return currentStage;
	}

	/**
	 * Método que agrega un history al panel de información que se utilizará
	 * para llevar un registro sobre jugadas o acciones que se realizan en el
	 * juego.
	 * 
	 * @param usuario
	 *            nombre que aparecerá en la primer columna informando quién fue
	 *            el que realizó el evento.
	 * @param mensaje
	 *            mensaje que se mostrará, para informar a los jugadores sobre
	 *            las acciones que se realizaró
	 * 
	 */
	private void addHistoryGame(String usuario, String mensaje) {
		History history = new History(StringUtils.getFechaActual(), usuario,
				mensaje);
		addHistoryGame(history);
	}

	/**
	 * Método que agrega un history al panel de información que se utilizará
	 * para llevar un registro sobre jugadas o acciones que se realizan en el
	 * juego.
	 * 
	 * @param history
	 *            objeto historia que contiene información sobre el usuario,
	 *            descripción del mensaje, y fecha en el que se produjó el
	 *            evento.
	 */
	public void addHistoryGame(final History history) {
		FutureTask<Void> taskAddHistory = null;
		try {
			taskAddHistory = new FutureTask<Void>(new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					historyGameList.add(history);

					oHistoryGameList = FXCollections
							.observableArrayList(historyGameList);

					if (lvHistoryGame != null) {
						lvHistoryGame.getItems().clear();
						lvHistoryGame.setItems(oHistoryGameList);
						lvHistoryGame
								.setCellFactory(new Callback<ListView<History>, javafx.scene.control.ListCell<History>>() {
									@Override
									public ListCell<History> call(
											ListView<History> listView) {
										return new ListCell<History>() {

											@Override
											protected void updateItem(
													History item, boolean bln) {
												super.updateItem(item, bln);
												if (item != null) {
													Text txtHistory = new Text(
															item.toString());
													txtHistory
															.setFill(Color.RED);
													setGraphic(txtHistory);
												}
											}

										};
									}
								});
					}
					return null;
				}
			});
			Platform.runLater(taskAddHistory);

		} catch (Exception ex) {
			GestorLogs.registrarException(ex);
		}
	}

	public void addChatHistoryGame(final History chatHistory) {

		FutureTask<Void> taskAddHistory = null;
		try {
			taskAddHistory = new FutureTask<Void>(new Callable<Void>() {
				@Override
				public Void call() throws Exception {
					historyChatList.add(chatHistory);

					oHistoryChatList = FXCollections
							.observableArrayList(historyChatList);

					if (lvHistoryChat != null) {
						lvHistoryChat.getItems().clear();
						lvHistoryChat.setItems(oHistoryChatList);
						lvHistoryChat
								.setCellFactory(new Callback<ListView<History>, javafx.scene.control.ListCell<History>>() {
									@Override
									public ListCell<History> call(
											ListView<History> listView) {
										return new ListCell<History>() {

											@Override
											protected void updateItem(
													History item, boolean bln) {
												super.updateItem(item, bln);
												if (item != null) {
													Text txtHistory = new Text(
															item.toChatString());
													txtHistory
															.setFill(Color.RED);
													setGraphic(txtHistory);
												}
											}

										};
									}
								});
					}
					return null;
				}
			});
			Platform.runLater(taskAddHistory);

		} catch (Exception ex) {
			GestorLogs.registrarException(ex);
		}
	}

	public void sendChatMessage() {
		Usuario usuario = usuarioLogueado;
		String mensaje = this.txtMessageChat.getText();

		History history = new History(StringUtils.getFechaActual(),
				usuario.getUserName(), mensaje);

		ChatGameMessage chatMessage = new ChatGameMessage(getJuego()
				.getUniqueID(), history);

		this.txtMessageChat.setText("");

		ConnectionController.getInstance().send(chatMessage);

	}

	/**
	 * Método que muestra un messagebox informando que el jugador debe esperar
	 * por oponentes.
	 */
	private void esperarJugadores() {
		preloaderStage = new Stage();

		try {

			String fxml = ConstantesFXML.FXML_SPLASH;
			Parent root;

			FXMLLoader loader = ScreensFramework.getLoader(fxml);

			root = (Parent) loader.load();

			Scene scene = new Scene(root);
			preloaderStage.setScene(scene);
			preloaderStage.setTitle("Monopoly - Esperando por jugadores");
			preloaderStage.centerOnScreen();
			preloaderStage.setResizable(false);
			preloaderStage.initModality(Modality.APPLICATION_MODAL);
			preloaderStage.initStyle(StageStyle.UNDECORATED);
			SplashController controller = (SplashController) loader
					.getController();
			controller.setController(TableroController.this);
			controller.setCurrentStage(preloaderStage);
			preloaderStage.show();

		} catch (Exception ex) {
			GestorLogs.registrarException(ex);
			showMessageBox(AlertType.ERROR, "Error...", null, ex.getMessage());
		}
	}

	/**
	 * Envía al servidor un mensaje para guardar en juego en un archivo para
	 * continuarlo más adelante
	 * 
	 */
	private void guardarJuego() {
		SaveGameMessage saveMessage = new SaveGameMessage(getJuego()
				.getUniqueID(), null);

		ConnectionController.getInstance().send(saveMessage);
	}

	/**
	 * Cierra la ventana del tablero y se desconecta
	 * 
	 * @param force
	 *            Especifica si se fuerza el cierre.
	 *            <ul>
	 *            <li>{@code false}: muestra un mensaje preguntando al usuario
	 *            si realmente desea salir del juego</li>
	 *            <li>{@code true}: sale del juego sin preguntarle al usuario</li>
	 *            </ul>
	 */
	private void cerrar(boolean force) {
		boolean answer = false;

		if (!force) {
			ButtonType result = showYesNoMsgBox("Abandonar juego", null,
					"¿Está seguro que desea abandonar el juego? Se perderá el progreso del juego.");
			if (result.getButtonData() == ButtonData.YES)
				answer = true;
		}
		if (force || answer) {
			GestorLogs.registrarLog("Saliendo de monopolio...");
			ConnectionController.getInstance().cerrarConexion();
			currentStage.close();
			Platform.exit();
			System.exit(0);
		}
	}

	/**
	 * Inicializa el reloj del tablero.
	 */
	public void createDigitalClock() {
		final Timeline timeline = new Timeline();

		timeline.setCycleCount(Timeline.INDEFINITE);
		final KeyFrame kf = new KeyFrame(Duration.seconds(1),
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						clockLabelTextProperty.setValue(StringUtils
								.getFechaActual());
					}
				});
		timeline.getKeyFrames().add(kf);
		timeline.play();
	}

	public void tirarDadosTurno() {
		Platform.runLater(new Runnable() {
			private Stage tirarDadosStage;

			@Override
			public void run() {
				String fxml;
				// TirarDadosTurnoController controller;
				TirarDadosController controller;
				try {
					fxml = ConstantesFXML.FXML_TIRAR_DADOS;
					tirarDadosStage = new Stage();
					// controller = (TirarDadosTurnoController) FXUtils
					controller = (TirarDadosController) FXUtils.cargarStage(
							tirarDadosStage, fxml,
							"Monopoly - Tirar Dados para turnos", false, false,
							Modality.APPLICATION_MODAL, StageStyle.UNDECORATED);
					controller.setCurrentStage(tirarDadosStage);
					controller.settearDatos(usuarioLogueado.getNombre());
					controller.setTipoTirada(TipoTiradaEnum.TIRAR_TURNO);
					SplashController.getInstance().getCurrentStage().close();
					tirarDadosStage.showAndWait();
				} catch (Exception ex) {
					GestorLogs.registrarException(ex);
					showMessageBox(AlertType.ERROR, "Error...", null,
							ex.getMessage());
				}
			}
		});
	}

	/**
	 * Realiza las diferentes acciones que se puede realizar en el juego en base
	 * al casillero al cual avanzó en el caso de que haya sido su turno. Si no
	 * lo fue informa al usuario las direntes estrategias realizada por los
	 * contrincantes.
	 * 
	 * @param estadoTurno
	 *            Toda las información del juego.
	 */
	public void actualizarEstadoJuego(MonopolyGameStatus monopolyGameStatus) {

		estadoActual = monopolyGameStatus;
		try {
			// Cargo la Historia del juego
			for (History history : estadoActual.hirtoryList) {
				addHistoryGame(history);
			}

			// Actualizo la información en el tablero.
			actualizarTurnoJugador();
			actualizarGraficoEnElTablero();

			switch (estadoActual.estadoTurno) {
			/*
			 * opción cuando al jugador le toca tirar el dado.
			 */
			case TIRAR_DADO:
				bloquearAcciones(false);
				mostrarTirarDados(true);
				showMessageBox(AlertType.INFORMATION, "Turno de juego...",
						null, "Es tu turno para jugar");
				break;
				
			case ACTUALIZANDO_ESTADO:
				bloquearAcciones(false);
				break;
				
			case JUGANDO:
				bloquearAcciones(true);
				mostrarTirarDados(false);
				realizarAccionEnCasillero();
				break;
			case ESPERANDO_TURNO:
				bloquearAcciones(true);
				mostrarTirarDados(false);
				break;
			case DADOS_DOBLES:
				showDadosDobles();
				break;
			case PRESO:
				showOpcionesCarcel();
				break;
			case LIBRE:
				bloquearAcciones(false);
				mostrarTirarDados(true);
				showMessageBox(AlertType.INFORMATION, "Turno de juego...",
						"Libre de la Cárcel.", "Continua jugando.");
				break;
			default:
				throw new CondicionInvalidaException("El estado de Turno "
						+ estadoActual.estadoTurno + " es inválido.");
			}
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(AlertType.ERROR, "Error...", null, ex.getMessage());
		}
	}

	private void realizarAccionEnCasillero() throws Exception {

		AccionEnCasillero accionCasillero = estadoActual.accionCasillero;
		Casillero casilleroActual = estadoActual.currentPlayer
				.getCasilleroActual();
		Jugador jugadorActual = estadoActual.currentPlayer;
		Tarjeta tarjetaSelected = estadoActual.tarjeta;
		List<Jugador> turnosList = estadoActual.turnos;
		String mensaje = estadoActual.getMensajeAux();
		int monto = estadoActual.getMonto();

		try {
			switch (accionCasillero) {

			case DESCANSO:
				// mensaje = String.format("Casillero %s, debe descansar.",
				// casilleroActual.getNombreCasillero());
				showMessageBox(AlertType.INFORMATION, "Descanso...", null,
						mensaje);
				finalizarTurno();
				break;

			case DISPONIBLE_PARA_VENDER:
				disponibleParalaVenta(jugadorActual, casilleroActual, mensaje);
				break;

			case TARJETA_SUERTE:
				showTarjetaSuerte((TarjetaSuerte) tarjetaSelected);
				break;

			case TARJETA_COMUNIDAD:
				showTarjetaComunidad((TarjetaComunidad) tarjetaSelected);
				break;

			case HIPOTECADA:
				showMessageBox(AlertType.INFORMATION,
						"Propiedad hipotecada...",
						"La Propiedad se encuentra hipotecada.", mensaje);
				finalizarTurno();
				break;

			case IMPUESTO_DE_LUJO:
				showImpuestoDeLujo(jugadorActual, mensaje, monto);
				break;

			case IMPUESTO_SOBRE_CAPITAL:
				showImpuestoSobreElCapital(jugadorActual, mensaje, monto);
				break;

			case MI_PROPIEDAD:
				showMessageBox(AlertType.INFORMATION, "Propiedad...", null,
						mensaje);
				finalizarTurno();
				break;

			case PAGAR_ALQUILER:
				pagarAlquiler(jugadorActual, casilleroActual, turnosList,
						mensaje, monto);
				break;

			case IR_A_LA_CARCEL:
				irALaCarcel(mensaje);
				break;

			default:
				showMessageBox(AlertType.ERROR, "Acción inválida",
						"Se Produjo un error.",
						"La acción %s no es una acción válida.");
				break;
			}
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(
					AlertType.ERROR,
					"Error...",
					"Se ha producido un error al realizar el movimiento en el casillero.",
					ex.getMessage());
		}
	}

	private void actualizarTurnoJugador() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				lblTurnoJugador.setText("Turno de "
						+ estadoActual.currentPlayer.getNombre());
			}
		});
	}

	private void showVentaPropiedad(final TarjetaPropiedad tarjetaPropiedad,
			final Jugador jugador) {
		Platform.runLater(new Runnable() {
			private Stage ventaPropiedadStage = null;
			private TarjetaPropiedad tarjeta = tarjetaPropiedad;
			private Jugador jugadorComprador = jugador;

			@Override
			public void run() {
				String fxml;
				VentaPropiedadController controller;

				try {

					fxml = ConstantesFXML.FXML_VENTA_PROPIEDAD;
					ventaPropiedadStage = new Stage();
					controller = (VentaPropiedadController) FXUtils
							.cargarStage(ventaPropiedadStage, fxml,
									"Monopoly - Comprar Propiedad", false,
									false, Modality.APPLICATION_MODAL,
									StageStyle.TRANSPARENT);
					controller.setCurrentStage(ventaPropiedadStage);
					controller.cargarPropiedad(tarjeta);
					controller.setJugadorComprador(jugadorComprador);
					ventaPropiedadStage.show();
				} catch (Exception ex) {
					GestorLogs.registrarException(ex);
					showMessageBox(
							AlertType.ERROR,
							"Error...",
							"Se ha producido un error al mostrar la Tarjeta de la Propiedad.",
							ex.getMessage());
				}
			}
		});
	}

	private void showTarjetaComunidad(final TarjetaComunidad tarjetaComunidad) {
		Platform.runLater(new Runnable() {
			private Stage tarjetaComunidadStage = null;
			private TarjetaComunidad tarjeta = tarjetaComunidad;

			@Override
			public void run() {
				String fxml;
				TarjetaComunidadController controller;

				try {

					fxml = ConstantesFXML.FXML_TARJETA_COMUNIDAD;
					tarjetaComunidadStage = new Stage();
					controller = (TarjetaComunidadController) FXUtils
							.cargarStage(tarjetaComunidadStage, fxml,
									"Monopoly - Tarjeta Comunidad", false,
									false, Modality.APPLICATION_MODAL,
									StageStyle.TRANSPARENT);
					controller.setCurrentStage(tarjetaComunidadStage);
					controller.setIdJuego(getJuego().getUniqueID());
					controller.mostrarTarjeta(tarjeta);
					tarjetaComunidadStage.show();
				} catch (Exception ex) {
					GestorLogs.registrarError(ex);
					showMessageBox(
							AlertType.ERROR,
							"Error...",
							"Se ha producido un error al mostrar la Tarjeta de la Comunidad.",
							ex.getMessage());
				}
			}
		});
	}

	private void showTarjetaSuerte(final TarjetaSuerte tarjetaSuerte) {
		Platform.runLater(new Runnable() {
			private Stage TarjetaSuerteStage = null;
			private TarjetaSuerte tarjeta = tarjetaSuerte;

			@Override
			public void run() {
				String fxml;
				TarjetaSuerteController controller;

				try {

					fxml = ConstantesFXML.FXML_TARJETA_SUERTE;
					TarjetaSuerteStage = new Stage();
					controller = (TarjetaSuerteController) FXUtils.cargarStage(
							TarjetaSuerteStage, fxml,
							"Monopoly - Tarjeta Suerte", false, false,
							Modality.APPLICATION_MODAL, StageStyle.TRANSPARENT);
					controller.setCurrentStage(TarjetaSuerteStage);
					controller.mostrarTarjeta(tarjeta);
					controller.setIdJuego(getJuego().getUniqueID());
					TarjetaSuerteStage.show();
				} catch (Exception ex) {
					GestorLogs.registrarError(ex);
					showMessageBox(
							AlertType.ERROR,
							"Error...",
							"Se ha producido un error al mostrar la Tarjeta de la Suerte.",
							ex.getMessage());
				}
			}
		});
	}

	private void showImpuestoSobreElCapital(final Jugador jugadorActual,
			final String mensaje, final int monto) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				String msgSinDinero;
				String idJuego;
				Alert alert;

				try {
					idJuego = juego.getUniqueID();
					msgSinDinero = "No cuentas con suficiente dinero para pagar %s. Vende hoteles, casas o hipoteca propiedades para continuar con el juego.";

					ButtonType buttonPorcentaje;
					ButtonType buttonMonto;
					List<ButtonType> buttons;
					Optional<ButtonType> result;
					SuperTaxMessage msgSuperTax = null;

					buttonPorcentaje = new ButtonType("Pagar 10%");
					buttonMonto = new ButtonType("Pagar "
							+ StringUtils.formatearAMoneda(200));
					buttons = new ArrayList<ButtonType>();
					buttons.add(buttonPorcentaje);
					buttons.add(buttonMonto);

					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Impuesto sobre el capital...");
					alert.setHeaderText("Debes pagar el impuesto.");
					alert.setContentText(mensaje);
					alert.getButtonTypes().setAll(buttons);
					result = alert.showAndWait();

					if (result.get() == buttonPorcentaje) {
						msgSuperTax = new SuperTaxMessage(juego.getUniqueID(),
								EnumsTipoImpuesto.TIPO_IMPUESTO_PORCENTAJE);
					} else {
						msgSuperTax = new SuperTaxMessage(idJuego,
								EnumsTipoImpuesto.TIPO_IMPUESTO_MONTO);

						if (jugadorActual.getDinero() < 200) {
							registrarDeuda(monto);
							showMessageBox(AlertType.WARNING,
									"Impuesto de sobre el capital...",
									"Debes pagar el impuesto.",
									String.format(msgSinDinero, "el impuesto"));
							return;
						}
					}
					ConnectionController.getInstance().send(msgSuperTax);

				} catch (Exception ex) {
					GestorLogs.registrarError(ex);
					showMessageBox(
							AlertType.ERROR,
							"Error",
							"Se ha producido un erro al mostrar Impuestos sobre el capital",
							ex.getMessage());
				}

			}
		});
	}

	/**
	 * Muestra un mensaje con el resultado del guardado del juego.
	 * 
	 * @param exception
	 *            Si el juego se guardó, {@code exception} es <code>null</code>.
	 *            Si hubo algún error, se pasa la excepción que se generó.
	 */
	public void showJuegoGuardado(IOException exception) {
		AlertType alertType;
		String msgHeader;
		String msgGuardado;

		if (exception == null) {
			alertType = AlertType.INFORMATION;
			msgHeader = "Juego guardado";
			msgGuardado = "El juego se guardó correctamente";
		} else {
			alertType = AlertType.ERROR;
			msgHeader = "El juego no se pudo guardar";
			msgGuardado = exception.getMessage();
		}

		showMessageBox(alertType, "Estado de Juego", msgHeader, msgGuardado);

		// Una vez que le informamos al usuario que el juego se guardó
		// correctamente, cerramos el juego
		if (exception == null)
			this.cerrar(true);
	}

	/**
	 * Muestra un mensaje de error.
	 * 
	 * @param exception
	 *            La {@code Exception} con el error.
	 */
	public void showException(Exception exception) {
		AlertType alertType = AlertType.ERROR;
		String msgHeader = "Error desconocido";
		String msgGuardado = "Se ha producido un error desconocido";

		if (exception != null) {
			msgHeader = "Se ha producido un error";
			msgGuardado = exception.toString();
		}

		showMessageBox(alertType, "Error", msgHeader, msgGuardado);
	}

	/**
	 * Muestra un mensaje para pagar el impuesto de lujo.
	 * 
	 * @param jugadorActual
	 * @param mensaje
	 * @param monto
	 */
	private void showImpuestoDeLujo(final Jugador jugadorActual,
			final String mensaje, final int monto) {
		PayToBankMessage msgPayToBank;
		String msgSinDinero;
		String idJuego;
		String mensajeAux;

		try {
			idJuego = juego.getUniqueID();
			msgSinDinero = "No cuentas con suficiente dinero para pagar %s. Vende hoteles, casas o hipoteca propiedades para continuar con el juego.";

			showMessageBox(AlertType.INFORMATION, "Impuesto de lujo...",
					"Debes pagar el impuesto.", mensaje);

			if (jugadorActual.getDinero() >= monto) {
				mensajeAux = String.format(
						"Ha pagado al banco %s de impuesto de lujo.",
						StringUtils.formatearAMoneda(100));
				msgPayToBank = new PayToBankMessage(idJuego, 100, mensajeAux);
				ConnectionController.getInstance().send(msgPayToBank);
			} else {
				registrarDeuda(monto);
				showMessageBox(AlertType.WARNING, "Impuesto de lujo...",
						"Debes pagar el impuesto.",
						String.format(msgSinDinero, "el impuesto"));
			}
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(AlertType.ERROR, "Error...",
					"Se ha producido un error al Pagar el Impuesto de Lujo.",
					ex.getMessage());
		}
	}

	/**
	 * Muestra un mensaje con información sobre la propiedad que se encuentra en
	 * venta.
	 * 
	 * @param jugadorActual
	 * @param casilleroActual
	 * @param mensaje
	 */
	private void disponibleParalaVenta(Jugador jugadorActual,
			Casillero casilleroActual, String mensaje) {

		try {
			showMessageBox(AlertType.INFORMATION,
					"Compra de propiedad dispobible...",
					casilleroActual.getNombreCasillero(), mensaje);

			switch (casilleroActual.getTipoCasillero()) {
			case C_CALLE:
				showVentaPropiedad(
						((CasilleroCalle) casilleroActual).getTarjetaCalle(),
						jugadorActual);
				break;
			case C_COMPANIA:
				showVentaPropiedad(
						((CasilleroCompania) casilleroActual)
								.getTarjetaCompania(),
						jugadorActual);
				break;

			case C_ESTACION:
				showVentaPropiedad(
						((CasilleroEstacion) casilleroActual)
								.getTarjetaEstacion(),
						jugadorActual);
				break;
			default:
				throw new CondicionInvalidaException(
						"Tipo de casillero inválido.");
			}
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(
					AlertType.ERROR,
					"Error...",
					"Se ha producido un error mientras se mostraba la Propiedad disponible para la Venta.",
					ex.getMessage());
		}
	}

	/**
	 * Muestra un mensaje informando cuando debe pagar al alquiler al jugador
	 * propietario.
	 * 
	 * @param jugadorActual
	 * @param casilleroActual
	 * @param turnosList
	 * @param mensaje
	 * @param monto
	 */
	private void pagarAlquiler(final Jugador jugadorActual,
			final Casillero casilleroActual, final List<Jugador> turnosList,
			final String mensaje, final int monto) {

		PayRentMessage msgPayRent;
		String msgSinDinero;
		String idJuego;
		try {
			idJuego = juego.getUniqueID();
			msgSinDinero = "No cuentas con suficiente dinero para pagar %s. Vende hoteles, casas o hipoteca propiedades para continuar con el juego.";

			showMessageBox(AlertType.INFORMATION, "Pagar...",
					"Pagar alquiler.", mensaje);
			if (jugadorActual.getDinero() >= monto) {
				msgPayRent = new PayRentMessage(idJuego,
						casilleroActual.getNumeroCasillero());
				ConnectionController.getInstance().send(msgPayRent);
			} else {
				registrarDeuda(monto);
				showMessageBox(AlertType.WARNING, "Alquiler...",
						"Debes pagar el alquiler.",
						String.format(msgSinDinero, "el alquiler"));
			}
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(AlertType.ERROR, "Error...",
					"Se ha producido un error al Pagar el Alquiler.",
					ex.getMessage());
		}
	}

	/**
	 * Muestra un mensaje informando que el jugador irá a la cárcel.
	 * 
	 * @param mensaje
	 */
	private void irALaCarcel(final String mensaje) {
		try {
			GoToJailMessage msgGoToJailMessage;

			showMessageBox(AlertType.INFORMATION, "Marche preso...", null,
					mensaje);
			// enviar mensaje;
			msgGoToJailMessage = new GoToJailMessage(juego.getUniqueID());
			ConnectionController.getInstance().send(msgGoToJailMessage);
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(AlertType.ERROR, "Error...",
					"Se ha producido un error al Ir a la Cárcel.",
					ex.getMessage());
		}
	}

	/**
	 * Muestra las opción que tiene el jugador para salir de la cárcel. Pueden
	 * ser:
	 * <ol>
	 * <li>Pagar un monto fijo</li>
	 * <li>Tirar dados dobles</li>
	 * <li>Utilizar una tarjeta de la cárcel</li>
	 * </ol>
	 */
	private void showOpcionesCarcel() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				String msgSinDinero;
				String idJuego;
				Alert alert;
				Jugador jugadorActual;
				PayToLeaveJailMessage msgPayToLeaveJail;

				try {
					idJuego = juego.getUniqueID();
					jugadorActual = estadoActual.currentPlayer;
					msgSinDinero = "No cuentas con suficiente dinero para pagar %s. Vende hoteles, casas o hipoteca propiedades para continuar con el juego.";

					ButtonType buttonPagar;
					ButtonType buttonUsarTarjeta;
					ButtonType buttonTirarDados;
					List<ButtonType> buttons;
					Optional<ButtonType> result;

					buttonPagar = new ButtonType(String.format("Pagar %s",
							StringUtils.formatearAMoneda(50)));
					buttonUsarTarjeta = new ButtonType("Usar Tarjeta");
					buttonTirarDados = new ButtonType("Sacar dados dobles");
					buttons = new ArrayList<ButtonType>();
					buttons.add(buttonPagar);
					if (jugadorActual.getTarjetaCarcelList().size() > 0) {
						buttons.add(buttonUsarTarjeta);
					}
					buttons.add(buttonTirarDados);

					alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Comisaria");
					alert.setHeaderText("Estás en la cárcel, debes salir.");
					alert.setContentText("Elige una opción para salir de la cárcel.");
					alert.getButtonTypes().setAll(buttons);
					result = alert.showAndWait();

					if (result.get() == buttonTirarDados) {
						bloquearAcciones(false);
						mostrarTirarDados(true);
					} else if (result.get() == buttonUsarTarjeta) {
						msgPayToLeaveJail = new PayToLeaveJailMessage(idJuego,
								EnumSalidaCarcel.USAR_TARJETA);
						ConnectionController.getInstance().send(
								msgPayToLeaveJail);
					} else {

						if (jugadorActual.getDinero() < 50) {
							registrarDeuda(50);
							showMessageBox(AlertType.WARNING, "Comisaria",
									"Debes pagar para salir de la cárcel.",
									String.format(msgSinDinero,
											"la salida de la cárcel"));
							return;
						} else {
							msgPayToLeaveJail = new PayToLeaveJailMessage(
									idJuego, EnumSalidaCarcel.PAGAR);
							ConnectionController.getInstance().send(
									msgPayToLeaveJail);
						}
					}

				} catch (Exception ex) {
					GestorLogs.registrarError(ex);
					showMessageBox(
							AlertType.ERROR,
							"Error",
							"Se ha producido un error al mostrar Opciones de la Cárcel.",
							ex.getMessage());
				}

			}
		});
	}

	public void showDadosDobles() {
		try {
			bloquearAcciones(false);
			mostrarTirarDados(true);
			showMessageBox(AlertType.INFORMATION, "Turno de juego...",
					"Dados dobles.", "Es tu turno nuevamente.");
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
		}
	}

	@SuppressWarnings("unused")
	private Jugador getPropietarioCasillero(Casillero casillero,
			List<Jugador> turnosList) {
		for (Jugador jugador : turnosList) {
			for (TarjetaPropiedad tarjeta : jugador.getTarjPropiedadList()) {
				if (tarjeta.getCasillero().getNumeroCasillero() == casillero
						.getNumeroCasillero())
					return jugador;
			}
		}
		return null;
	}

	private void registrarDeuda(int pMonto) throws Exception {
		bloquearAcciones(false);
		mostrarTirarDados(false);
		mostrarFinalizarTurno(true);
		deudaPendiente = new Deuda(pMonto);

	}

	// =======================================================================//
	// =========== Métodos para dibujar componentes en la pantalla ===========//
	// =======================================================================//

	private void actualizarGraficoEnElTablero() throws Exception {
		displayFichas(estadoActual.turnos);
		displayCasasYHoteles(estadoActual.tablero.getCasillerosList());
		showAccordionJugadores(estadoActual.turnos, estadoActual.banco);
	}

	/**
	 * Método que dibuja a los jugadores, mostrando el estado en el juego.
	 * 
	 */
	private void showAccordionJugadores(List<Jugador> turnosList, Banco banco)
			throws Exception {
		tps = new TitledPane[turnosList.size() + 1];
		String title;

		for (int i = 0; i < turnosList.size(); i++) {
			title = turnosList.get(i).getNombre() + " - ";
			title += StringUtils
					.formatearAMoneda(turnosList.get(i).getDinero()) + " - ";
			title += (turnosList.get(i).isHumano()) ? "Jugador Humano"
					: "Jugador Virtual";
			tps[i] = getPaneInfoPlayer(turnosList.get(i), title, banco);
		}
		tps[turnosList.size()] = getPaneInfoBanco(banco, "BANCO");

		final TitledPane[] tpJugadores = tps;
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				accordionPlayers.getPanes().clear();
				accordionPlayers.getPanes().addAll(tpJugadores);
				accordionPlayers.setExpandedPane(tpJugadores[0]);
			}
		});

	}

	/**
	 * Método que dibuja las fichas en el tablero.
	 * 
	 * @throws Exception
	 */
	private void displayFichas(List<Jugador> turnosList) throws Exception {
		limpiarCasilleros();

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				TilePane tpCasilleroSelected = null;
				Casillero casilleroActual;
				try {
					for (Jugador jugadorTurno : turnosList) {
						casilleroActual = jugadorTurno.getCasilleroActual();
						final Image img = new Image(TableroController.class
								.getResourceAsStream(jugadorTurno.getFicha()
										.getPathImgSmall()), 25, 25, true, true);

						tpCasilleroSelected = (TilePane) pTablero
								.lookup("#pCasillero"
										+ String.format("%02d", casilleroActual
												.getNumeroCasillero()));
						if (tpCasilleroSelected != null) {
							tpCasilleroSelected.getChildren().add(
									new ImageView(img));
						} else {
							throw new CondicionInvalidaException(String.format(
									"Casillero inválido: %s", jugadorTurno
											.getCasilleroActual()
											.getNumeroCasillero()));
						}
					}
				} catch (Exception ex) {
					GestorLogs.registrarException(ex);
				}
			}
		});
	}

	private void displayCasasYHoteles(Casillero[] casilleros) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Image imgCasa;
				TilePane tpCasilleroSelected = null;

				try {
					for (Casillero casillero : casilleros) {
						if (casillero.isCasilleroCalle()
								&& ((CasilleroCalle) casillero).getNroCasas() > 0) {

							tpCasilleroSelected = (TilePane) pTablero
									.lookup("#pCasillero"
											+ String.format("%02d", casillero
													.getNumeroCasillero()));
							if (tpCasilleroSelected != null) {

								switch (((CasilleroCalle) casillero)
										.getNroCasas()) {
								case 1:
									imgCasa = new Image(
											TableroController.class
													.getResourceAsStream("/images/fichas/CasaS01.png"),
											18, 18, false, false);
									tpCasilleroSelected.getChildren().add(
											new ImageView(imgCasa));
									break;
								case 2:
									imgCasa = new Image(
											TableroController.class
													.getResourceAsStream("/images/fichas/CasaS02.png"),
											32, 18, false, false);
									tpCasilleroSelected.getChildren().add(
											new ImageView(imgCasa));
									break;
								case 3:
									imgCasa = new Image(
											TableroController.class
													.getResourceAsStream("/images/fichas/CasaS03.png"),
											40, 18, false, false);
									tpCasilleroSelected.getChildren().add(
											new ImageView(imgCasa));
									break;
								case 4:
									imgCasa = new Image(
											TableroController.class
													.getResourceAsStream("/images/fichas/CasaS04.png"),
											50, 18, false, false);
									tpCasilleroSelected.getChildren().add(
											new ImageView(imgCasa));
									break;
								case 5:
									imgCasa = new Image(
											TableroController.class
													.getResourceAsStream("/images/fichas/CasaS05.png"),
											30, 24, false, false);
									tpCasilleroSelected.getChildren().add(
											new ImageView(imgCasa));
									break;
								default:

									break;
								}

							} else {
								throw new CondicionInvalidaException(String
										.format("Casillero inválido: %s",
												casillero.getNumeroCasillero()));
							}

						}
					}
				} catch (Exception ex) {
					GestorLogs.registrarException(ex);
				}
			}
		});
	}

	private void bloquearAcciones(final boolean bloquear) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				btnAcciones.setDisable(bloquear);
				btnConstruir.setDisable(bloquear);
				btnComercializar.setDisable(bloquear);
				btnDeshipotecar.setDisable(bloquear);
				btnHipotecar.setDisable(bloquear);
				btnVender.setDisable(bloquear);
			}
		});
	}

	@SuppressWarnings("unused")
	private void desbloquearVenta() throws Exception {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				btnHipotecar.setDisable(false);
				btnVender.setDisable(false);
				btnComercializar.setDisable(false);
			}
		});
	}

	private void mostrarTirarDados(final boolean pbMostrar) throws Exception {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				btnTirarDados.setVisible(pbMostrar);
			}
		});
	}

	private void mostrarFinalizarTurno(final boolean pbMostrar)
			throws Exception {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				btnFinalizarTurno.setVisible(pbMostrar);
			}
		});
	}

	private void finalizarTurno() throws Exception {

		CompleteTurnMessage msg = new CompleteTurnMessage(getJuego()
				.getUniqueID(), null, null);
		ConnectionController.getInstance().send(msg);
	}

	/**
	 * 
	 * Dibuje el TitledPane con la información actual del jugador.
	 * 
	 * @param jugador
	 * @param title
	 * @return
	 */
	private TitledPane getPaneInfoPlayer(Jugador jugador, String title,
			Banco banco) throws Exception {

		AnchorPane root = new AnchorPane();
		VBox vBox = new VBox();
		VBox pImgFicha = new VBox();
		HBox hbPropiedades = new HBox();
		HBox hbExtra = new HBox();
		ScrollPane scroll;

		acoplarAContenedor(vBox, 0);
		root.getStyleClass().add("bg_info_panel");
		root.setPadding(new Insets(10));
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);

		hbPropiedades.setAlignment(Pos.CENTER);
		hbPropiedades.setSpacing(20);

		hbExtra.setAlignment(Pos.CENTER);
		hbExtra.setSpacing(20);

		vBox.getChildren().add(hbPropiedades);
		vBox.getChildren().add(hbExtra);

		root.getChildren().add(vBox);
		scroll = makeScrollable(root);

		acoplarAContenedor(pImgFicha, 0);
		pImgFicha.setAlignment(Pos.CENTER);
		pImgFicha.getStyleClass().add("bg_info_ficha");
		pImgFicha.setPrefSize((double) 60, (double) 60);

		// ===================== HBox de propiedades =====================//

		TarjetaPropiedad propiedad;
		String rutaImagen = "";
		String strStyle = "";
		Boolean bCrearImagen = false;
		String strToolTip = "";
		double hbWidth = 35;
		double hbHeight = 60;
		List<String[]> vTarjetas = new ArrayList<String[]>();

		GridPane gridPane1 = new GridPane();
		GridPane gridPane2 = new GridPane();

		acoplarAContenedor(gridPane1, 0);
		acoplarAContenedor(gridPane2, 0);

		gridPane1.setHgap(5);
		gridPane1.setVgap(10);

		gridPane2.setHgap(5);
		gridPane2.setVgap(10);

		// Tarjetas para el gridpane1
		vTarjetas.add(new String[] { "tarjeta02", "0", "0" });
		vTarjetas.add(new String[] { "tarjeta04", "1", "0" });
		vTarjetas.add(new String[] { "tarjeta07", "0", "1", });
		vTarjetas.add(new String[] { "tarjeta09", "1", "1", });
		vTarjetas.add(new String[] { "tarjeta10", "2", "1", });
		vTarjetas.add(new String[] { "tarjeta12", "0", "2", });
		vTarjetas.add(new String[] { "tarjeta14", "1", "2", });
		vTarjetas.add(new String[] { "tarjeta15", "2", "2", });
		vTarjetas.add(new String[] { "tarjeta17", "0", "3", });
		vTarjetas.add(new String[] { "tarjeta19", "1", "3", });
		vTarjetas.add(new String[] { "tarjeta20", "2", "3", });
		vTarjetas.add(new String[] { "tarjeta22", "0", "4", });
		vTarjetas.add(new String[] { "tarjeta24", "1", "4", });
		vTarjetas.add(new String[] { "tarjeta25", "2", "4", });

		for (String[] vTarjeta : vTarjetas) {
			propiedad = banco.getTarjetaPropiedad(vTarjeta[0]);
			if (propiedad != null) {
				if (propiedad.isPropiedadCalle()) {
					strStyle = ((TarjetaCalle) (propiedad)).getColor();
				} else {
					if (propiedad.isPropiedadCompania())
						strStyle = "blanco";
					else
						strStyle = "negro";
				}
				bCrearImagen = false;
				if (jugador.getTarjPropiedadList().contains(propiedad)) {
					bCrearImagen = true;
					if (!propiedad.isHipotecada())
						rutaImagen = propiedad.getPathImagenFrente();
					else
						rutaImagen = propiedad.getPathImagenDorso();
					strToolTip = showToolTipsPropiedad(propiedad);
				}
				gridPane1.add(
						crearHBoxTarjetaPropiedad(strStyle, bCrearImagen,
								rutaImagen, hbWidth, hbHeight, strToolTip),
						Integer.parseInt(vTarjeta[1]), Integer
								.parseInt(vTarjeta[2]));
			}
		}

		// Tarjetas para el gridpane2
		vTarjetas = new ArrayList<String[]>();
		vTarjetas.add(new String[] { "tarjeta27", "0", "0", });
		vTarjetas.add(new String[] { "tarjeta28", "1", "0", });
		vTarjetas.add(new String[] { "tarjeta30", "2", "0", });
		vTarjetas.add(new String[] { "tarjeta32", "0", "1", });
		vTarjetas.add(new String[] { "tarjeta33", "1", "1", });
		vTarjetas.add(new String[] { "tarjeta35", "2", "1", });
		vTarjetas.add(new String[] { "tarjeta38", "0", "2", });
		vTarjetas.add(new String[] { "tarjeta40", "1", "2", });
		vTarjetas.add(new String[] { "tarjeta13", "0", "3", });
		vTarjetas.add(new String[] { "tarjeta29", "1", "3", });
		vTarjetas.add(new String[] { "tarjeta06", "0", "4", });
		vTarjetas.add(new String[] { "tarjeta16", "1", "4", });
		vTarjetas.add(new String[] { "tarjeta26", "2", "4", });
		vTarjetas.add(new String[] { "tarjeta36", "3", "4", });

		for (String[] vTarjeta : vTarjetas) {
			propiedad = banco.getTarjetaPropiedad(vTarjeta[0]);
			if (propiedad != null) {
				if (propiedad.isPropiedadCalle()) {
					strStyle = ((TarjetaCalle) (propiedad)).getColor();
				} else {
					if (propiedad.isPropiedadCompania())
						strStyle = "blanco";
					else
						strStyle = "negro";
				}
				bCrearImagen = false;
				if (jugador.getTarjPropiedadList().contains(propiedad)) {
					bCrearImagen = true;
					if (!propiedad.isHipotecada())
						rutaImagen = propiedad.getPathImagenFrente();
					else
						rutaImagen = propiedad.getPathImagenDorso();
					strToolTip = showToolTipsPropiedad(propiedad);
				}
				gridPane2.add(
						crearHBoxTarjetaPropiedad(strStyle, bCrearImagen,
								rutaImagen, hbWidth, hbHeight, strToolTip),
						Integer.parseInt(vTarjeta[1]), Integer
								.parseInt(vTarjeta[2]));
			}
		}

		hbPropiedades.getChildren().add(gridPane1);
		hbPropiedades.getChildren().add(gridPane2);

		// ===================== Area extra =========================//

		Image imgCasa;
		Image imgHotel;
		Image imgCarcel;

		imgCasa = new Image(
				TableroController.class
						.getResourceAsStream("/images/fichas/Casa01.png"),
				30, 30, false, false);
		imgHotel = new Image(
				TableroController.class
						.getResourceAsStream("/images/fichas/Casa05.png"),
				30, 30, false, false);

		imgCarcel = new Image(
				TableroController.class
						.getResourceAsStream("/images/tarjetas/Carcel.jpg"),
				30, 30, false, false);

		Label lblDescripcion;

		hbExtra.getChildren().add(new ImageView(imgCasa));
		lblDescripcion = new Label("x " + jugador.getNroCasas());
		lblDescripcion.setStyle("-fx-text-fill: white;");
		hbExtra.getChildren().add(lblDescripcion);

		hbExtra.getChildren().add(new ImageView(imgHotel));
		lblDescripcion = new Label("x " + jugador.getNroHoteles());
		lblDescripcion.setStyle("-fx-text-fill: white;");
		hbExtra.getChildren().add(lblDescripcion);
		hbExtra.getChildren().add(new ImageView(imgCarcel));
		lblDescripcion = new Label("x " + jugador.getTarjetaCarcelList().size());
		lblDescripcion.setStyle("-fx-text-fill: white;");
		hbExtra.getChildren().add(lblDescripcion);

		TitledPane tpInfoPlayer = new TitledPane(title, scroll);
		tpInfoPlayer.setStyle("-fx-text-fill: white;");
		tpInfoPlayer.setId("tp_" + jugador.getNombre());
		tpInfoPlayer.setCollapsible(true);

		Image img = new Image(
				TableroController.class.getResourceAsStream(jugador.getFicha()
						.getPathImgSmall()), 25d, 25d, true, true);
		ImageView ivFicha = new ImageView(img);
		tpInfoPlayer.setGraphic(ivFicha);
		return tpInfoPlayer;
	}

	/**
	 * 
	 * Dibuja el TitledPan con la información actual del banco.
	 * 
	 * @param banco
	 * @param title
	 * @return
	 */
	private TitledPane getPaneInfoBanco(Banco banco, String title) {
		AnchorPane root = new AnchorPane();
		VBox vBox = new VBox();
		HBox hbPropiedades = new HBox();
		HBox hbExtra = new HBox();
		ScrollPane scroll;

		root.getStyleClass().add("bg_info_panel");
		root.setPadding(new Insets(10));
		vBox.setAlignment(Pos.CENTER);
		vBox.setSpacing(10);

		hbPropiedades.setAlignment(Pos.CENTER);
		hbPropiedades.setSpacing(20);

		hbExtra.setAlignment(Pos.CENTER);
		hbExtra.setSpacing(20);

		acoplarAContenedor(vBox, 0);
		vBox.getChildren().add(hbPropiedades);
		vBox.getChildren().add(hbExtra);

		root.getChildren().add(vBox);
		scroll = makeScrollable(root);
		scroll.autosize();

		// ===================== HBox de propiedades =====================//

		TarjetaPropiedad propiedad;
		String rutaImagen = "";
		String strStyle = "";
		Boolean bCrearImagen = false;
		String strToolTip = "";
		double hbWidth = 35;
		double hbHeight = 60;

		GridPane gridPane1 = new GridPane();
		GridPane gridPane2 = new GridPane();

		acoplarAContenedor(gridPane1, 0);
		acoplarAContenedor(gridPane2, 0);

		gridPane1.setHgap(5);
		gridPane1.setVgap(10);

		gridPane2.setHgap(5);
		gridPane2.setVgap(10);

		List<String[]> vTarjetas = new ArrayList<String[]>();

		// Tarjetas para el gridpane1
		vTarjetas.add(new String[] { "tarjeta02", "0", "0" });
		vTarjetas.add(new String[] { "tarjeta04", "1", "0" });
		vTarjetas.add(new String[] { "tarjeta07", "0", "1", });
		vTarjetas.add(new String[] { "tarjeta09", "1", "1", });
		vTarjetas.add(new String[] { "tarjeta10", "2", "1", });
		vTarjetas.add(new String[] { "tarjeta12", "0", "2", });
		vTarjetas.add(new String[] { "tarjeta14", "1", "2", });
		vTarjetas.add(new String[] { "tarjeta15", "2", "2", });
		vTarjetas.add(new String[] { "tarjeta17", "0", "3", });
		vTarjetas.add(new String[] { "tarjeta19", "1", "3", });
		vTarjetas.add(new String[] { "tarjeta20", "2", "3", });
		vTarjetas.add(new String[] { "tarjeta22", "0", "4", });
		vTarjetas.add(new String[] { "tarjeta24", "1", "4", });
		vTarjetas.add(new String[] { "tarjeta25", "2", "4", });

		for (String[] vTarjeta : vTarjetas) {
			propiedad = banco.getTarjetaPropiedad(vTarjeta[0]);
			if (propiedad != null) {
				if (propiedad instanceof TarjetaCalle) {
					strStyle = ((TarjetaCalle) (propiedad)).getColor();
				} else {
					if (propiedad instanceof TarjetaCompania)
						strStyle = "blanco";
					else
						strStyle = "negro";
				}
				bCrearImagen = false;
				if (propiedad.getJugador() == null) {
					bCrearImagen = true;
					rutaImagen = propiedad.getPathImagenFrente();
					strToolTip = showToolTipsPropiedad(propiedad);
				}
				gridPane1.add(
						crearHBoxTarjetaPropiedad(strStyle, bCrearImagen,
								rutaImagen, hbWidth, hbHeight, strToolTip),
						Integer.parseInt(vTarjeta[1]), Integer
								.parseInt(vTarjeta[2]));
			}
		}

		// Tarjetas para el gridpane2
		vTarjetas = new ArrayList<String[]>();
		vTarjetas.add(new String[] { "tarjeta27", "0", "0", });
		vTarjetas.add(new String[] { "tarjeta28", "1", "0", });
		vTarjetas.add(new String[] { "tarjeta30", "2", "0", });
		vTarjetas.add(new String[] { "tarjeta32", "0", "1", });
		vTarjetas.add(new String[] { "tarjeta33", "1", "1", });
		vTarjetas.add(new String[] { "tarjeta35", "2", "1", });
		vTarjetas.add(new String[] { "tarjeta38", "0", "2", });
		vTarjetas.add(new String[] { "tarjeta40", "1", "2", });
		vTarjetas.add(new String[] { "tarjeta13", "0", "3", });
		vTarjetas.add(new String[] { "tarjeta29", "1", "3", });
		vTarjetas.add(new String[] { "tarjeta06", "0", "4", });
		vTarjetas.add(new String[] { "tarjeta16", "1", "4", });
		vTarjetas.add(new String[] { "tarjeta26", "2", "4", });
		vTarjetas.add(new String[] { "tarjeta36", "3", "4", });

		for (String[] vTarjeta : vTarjetas) {
			propiedad = banco.getTarjetaPropiedad(vTarjeta[0]);
			if (propiedad != null) {
				if (propiedad instanceof TarjetaCalle) {
					strStyle = ((TarjetaCalle) (propiedad)).getColor();
				} else {
					if (propiedad instanceof TarjetaCompania)
						strStyle = "blanco";
					else
						strStyle = "negro";
				}
				bCrearImagen = false;
				if (propiedad.getJugador() == null) {
					bCrearImagen = true;
					rutaImagen = propiedad.getPathImagenFrente();
					strToolTip = showToolTipsPropiedad(propiedad);
				}
				gridPane2.add(
						crearHBoxTarjetaPropiedad(strStyle, bCrearImagen,
								rutaImagen, hbWidth, hbHeight, strToolTip),
						Integer.parseInt(vTarjeta[1]), Integer
								.parseInt(vTarjeta[2]));
			}
		}

		hbPropiedades.getChildren().add(gridPane1);
		hbPropiedades.getChildren().add(gridPane2);

		// ===================== Area extra =========================//

		Image imgCasa;
		Image imgHotel;

		imgCasa = new Image(
				TableroController.class
						.getResourceAsStream("/images/fichas/Casa01.png"),
				30, 30, false, false);
		imgHotel = new Image(
				TableroController.class
						.getResourceAsStream("/images/fichas/Casa05.png"),
				30, 30, false, false);

		hbExtra.getChildren().add(new ImageView(imgCasa));
		hbExtra.getChildren().add(new Label("x " + banco.getNroCasas()));
		hbExtra.getChildren().add(new ImageView(imgHotel));
		hbExtra.getChildren().add(new Label("x " + banco.getNroHoteles()));

		TitledPane tpBanco = new TitledPane(title, scroll);
		tpBanco.setId("tp_banco");
		tpBanco.setStyle("-fx-text-fill: white;");
		tpBanco.setCollapsible(true);
		return tpBanco;
	}

	private HBox crearHBoxTarjetaPropiedad(final String style,
			final boolean creaImagen, final String rutaImagen,
			final Double hbWidth, final Double hbHeight, final String toolTips) {
		final HBox hBox_inner = new HBox();

		Platform.runLater(new Runnable() {
			@Override
			public void run() {

				Image imgPropiedad;
				Tooltip tpImagen;

				hBox_inner.getStyleClass().add("border_" + style.toLowerCase());
				hBox_inner.setPrefSize(hbWidth, hbHeight);

				if (creaImagen) {
					imgPropiedad = new Image(TableroController.class
							.getResourceAsStream(rutaImagen), hbWidth,
							hbHeight, false, false);
					hBox_inner.getChildren().add(new ImageView(imgPropiedad));
					tpImagen = new Tooltip(toolTips);
					imgPropiedad = new Image(TableroController.class
							.getResourceAsStream(rutaImagen), 250, 284, false,
							false);
					tpImagen.setGraphic(new ImageView(imgPropiedad));
					tpImagen.setAutoHide(false);
					Tooltip.install(hBox_inner, tpImagen);
				}

			}
		});

		return hBox_inner;
	}

	private void acoplarAContenedor(javafx.scene.Node node, double valor) {
		AnchorPane.setLeftAnchor(node, (double) 0);
		AnchorPane.setRightAnchor(node, (double) 0);
		AnchorPane.setTopAnchor(node, (double) 0);
		AnchorPane.setBottomAnchor(node, (double) 0);
	}

	/**
	 * Método para agregar un tooltips a la imagen de la propiedad con
	 * información sobre la misma.
	 * 
	 * @param propiedad
	 * @return
	 */
	private String showToolTipsPropiedad(TarjetaPropiedad propiedad) {
		String tooltip = propiedad.getNombre();
		if (propiedad.isHipotecada())
			tooltip += "(Hipotecada)";
		tooltip += " - "
				+ StringUtils.formatearAMoneda(propiedad.getValorPropiedad());
		return tooltip;
	}

	/**
	 * Crea la barra de desplazamiento a un componente.
	 * 
	 * @param node
	 *            componente para el cual se agregará la barra de
	 *            desplazamiento.
	 * @return el objeto scrolleable.
	 */
	private ScrollPane makeScrollable(final AnchorPane node) {
		final ScrollPane scroll = new ScrollPane();
		scroll.setContent(node);
		scroll.viewportBoundsProperty().addListener(
				new ChangeListener<Bounds>() {
					@Override
					public void changed(ObservableValue<? extends Bounds> ov,
							Bounds oldBounds, Bounds bounds) {
						node.setPrefWidth(bounds.getWidth());
					}
				});
		return scroll;
	}

	/**
	 * Borra todos los elementos que estan dibujados en todos los casillero del
	 * tablero.
	 */
	private void limpiarCasilleros() throws Exception {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				pCasillero01.getChildren().clear();
				pCasillero02.getChildren().clear();
				pCasillero03.getChildren().clear();
				pCasillero04.getChildren().clear();
				pCasillero05.getChildren().clear();
				pCasillero06.getChildren().clear();
				pCasillero07.getChildren().clear();
				pCasillero08.getChildren().clear();
				pCasillero01.getChildren().clear();
				pCasillero10.getChildren().clear();
				pCasillero11.getChildren().clear();
				pCasillero12.getChildren().clear();
				pCasillero13.getChildren().clear();
				pCasillero14.getChildren().clear();
				pCasillero15.getChildren().clear();
				pCasillero16.getChildren().clear();
				pCasillero17.getChildren().clear();
				pCasillero18.getChildren().clear();
				pCasillero19.getChildren().clear();
				pCasillero20.getChildren().clear();
				pCasillero21.getChildren().clear();
				pCasillero22.getChildren().clear();
				pCasillero23.getChildren().clear();
				pCasillero24.getChildren().clear();
				pCasillero25.getChildren().clear();
				pCasillero26.getChildren().clear();
				pCasillero27.getChildren().clear();
				pCasillero28.getChildren().clear();
				pCasillero29.getChildren().clear();
				pCasillero30.getChildren().clear();
				pCasillero31.getChildren().clear();
				pCasillero32.getChildren().clear();
				pCasillero33.getChildren().clear();
				pCasillero34.getChildren().clear();
				pCasillero35.getChildren().clear();
				pCasillero36.getChildren().clear();
				pCasillero37.getChildren().clear();
				pCasillero38.getChildren().clear();
				pCasillero39.getChildren().clear();
				pCasillero40.getChildren().clear();
			}
		});
	}

	/**
	 * Método para mostrar un mensaje en la pantalla.
	 * 
	 * @param type
	 *            El tipo de mensaje. Es del tipo
	 *            {@link javafx.scene.control.Alert.AlertType}
	 * @param title
	 *            El título del mensaje
	 * @param headerText
	 *            El encabezado del mensaje
	 * @param message
	 *            El mensaje a mostrar
	 */
	public void showMessageBox(final AlertType type, final String title,
			final String headerText, final String message) {
		FutureTask<Void> taskMessage = null;
		try {

			taskMessage = new FutureTask<Void>(new Callable<Void>() {

				@Override
				public Void call() throws Exception {

					ButtonType buttonAceptar;

					final Alert alert = new Alert(type);

					alert.setTitle(title);
					alert.setHeaderText(headerText);
					alert.setContentText(message);
					buttonAceptar = new ButtonType("Aceptar",
							ButtonData.OK_DONE);
					alert.getButtonTypes().setAll(buttonAceptar);

					DialogPane dialogPane = alert.getDialogPane();
					// dialogPane.getStyleClass().remove("alert");
					dialogPane.getStylesheets().add(
							getClass().getResource("/css/Dialog.css")
									.toExternalForm());
					dialogPane.getStyleClass().add("dialog");
					// setearEstiloMessageBox(alert);

					alert.showAndWait();
					return null;

				}
			});
			Platform.runLater(taskMessage);
			taskMessage.get();

		} catch (Exception ex) {
			GestorLogs.registrarException(ex);
		}
	}

	@SuppressWarnings("unused")
	private void setearEstiloMessageBox(final Alert alert) {
		String styleBg;
		String style;
		DialogPane dialogPane = alert.getDialogPane();
		// root
		styleBg = "-fx-background-image: url(\"../images/background/Grey-background.png\"); ";
		styleBg += "-fx-background-repeat: repeat; ";
		styleBg += "-fx-background-color:";
		styleBg += "linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),";
		styleBg += "linear-gradient(#20262b, #191d22),";
		styleBg += "radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));";

		dialogPane.setStyle(styleBg);

		// 1. Grid
		// remove style to customize header
		dialogPane.getStyleClass().remove("alert");

		GridPane grid = (GridPane) dialogPane.lookup(".header-panel");
		grid.setStyle(styleBg);

		style = "-fx-font-family: \"Arial\";";
		style += "-fx-font-size: 20px;";
		style += "-fx-font-weight: bold;";
		style += "-fx-text-fill: rgb(255,255,255);";
		style += "-fx-effect: dropshadow( one-pass-box , #5C5C5C, 0.1, 0.1 , 0.1 , 1.9 );";
		if (grid.lookup(".label") != null)
			grid.lookup(".label").setStyle(style);

		// 2. ContentText with just a Label
		style = "-fx-font-family: \"Arial\";";
		style += "-fx-font-size: 18px;";
		style += "-fx-font-style: italic;";
		style += "-fx-text-fill: rgb(255,255,255);";
		style += "-fx-effect: dropshadow( one-pass-box , #5C5C5C, 0.1, 0.1 , 0.1 , 1.9 );";
		dialogPane.lookup(".content.label").setStyle(style);

		// 3- ButtonBar
		ButtonBar buttonBar = (ButtonBar) alert.getDialogPane().lookup(
				".button-bar");
		buttonBar.setStyle(styleBg);

		final String styleButton = "-fx-background-color:rgb(255, 255, 255, 0.08),rgb(0, 0, 0, 0.8)"
				+ ",#090a0c,linear-gradient(#4a5661 0%, #1f2429 20%, #1f242a 100%)"
				+ ",linear-gradient(#242a2e, #23282e)"
				+ ",radial-gradient(center 50% 0%, radius 100%, rgba(135,142,148,0.9)"
				+ ",rgba(255,255,255,0));"
				+ "-fx-background-radius: 7, 6, 5, 4, 3, 5;"
				+ "-fx-background-insets: -3 -3 -4 -3, -3, 0, 1, 2, 0;"
				+ "-fx-font-family: \"Arial\";"
				+ "-fx-font-size: 18;"
				+ "-fx-text-fill: rgb(255,255,255);"
				+ "-fx-effect: dropshadow( one-pass-box , #5C5C5C, 0.1, 0.1 , 0.1 , 0.1 );"
				+ "-fx-padding: 5 5 5 5;";
		buttonBar.getButtons().forEach(b -> b.setStyle(styleButton));
	}

	/**
	 * Método para mostrar un mensaje en la pantalla que requiere de una
	 * respuesta SI/NO
	 * 
	 * @param title
	 *            El título del mensaje
	 * @param headerText
	 *            El encabezado del mensaje
	 * @param message
	 *            El mensaje a mostrar
	 * @return La respuesta del usuario
	 */
	public ButtonType showYesNoMsgBox(final String title,
			final String headerText, final String message) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(message);

		ButtonType buttonYes;
		ButtonType buttonNo;

		buttonYes = new ButtonType("Si", ButtonData.YES);
		buttonNo = new ButtonType("No", ButtonData.NO);
		alert.getButtonTypes().setAll(buttonYes, buttonNo);

		Optional<ButtonType> result = alert.showAndWait();

		return result.get();

	}

	// ======================================================================//
	// ============================== Event Fx ==============================//
	// ======================================================================//

	/**
	 * Método que muestra un messagebox para que el jugador tire los dados para
	 * determinar el turno de inicio de juego.
	 * 
	 * @param event
	 */
	@FXML
	public void processTirarDados(ActionEvent event) {

		Platform.runLater(new Runnable() {
			private Stage tirarDadosStage;

			@Override
			public void run() {
				String fxml;
				String title;
				TirarDadosController controller;

				try {
					btnAcciones.setDisable(true);
					fxml = ConstantesFXML.FXML_TIRAR_DADOS;
					tirarDadosStage = new Stage();
					title = estadoActual.currentPlayer.estaPreso() ? "Monopoly - Tirar Dados dobles."
							: "Monopoly - Tirar Dados avance de casilleros";
					controller = (TirarDadosController) FXUtils.cargarStage(
							tirarDadosStage, fxml, title, false, false,
							Modality.APPLICATION_MODAL, StageStyle.DECORATED);
					controller.setCurrentStage(tirarDadosStage);
					controller.settearDatos(usuarioLogueado.getNombre());
					if (estadoActual.currentPlayer.estaPreso())
						controller.setTipoTirada(TipoTiradaEnum.TIRAR_CARCEL);
					else
						controller.setTipoTirada(TipoTiradaEnum.TIRAR_AVANCE);
					tirarDadosStage.showAndWait();

				} catch (Exception ex) {
					GestorLogs.registrarException(ex);
					showMessageBox(AlertType.ERROR, "Error...", null,
							ex.getMessage());
				}
			}
		});
	}

	@FXML
	void processMenu(ActionEvent event) {

	}

	@FXML
	void processAcciones(ActionEvent event) {

	}

	@FXML
	void processContruir(ActionEvent event) {

	}

	@FXML
	void processVender(ActionEvent event) {

	}

	/**
	 * Abre la ventana para hipotecar las propiedades. Muestra solo las
	 * propiedades que puede hipotecar.
	 * 
	 * @param event
	 */
	@FXML
	void processHipotecar(ActionEvent event) {

		GestorLogs.registrarLog("Mostrando propiedades para hipotecar de '"
				+ usuarioLogueado.getNombre() + "'...");
		String fxml = ConstantesFXML.FXML_HIPOTECAR_PROPIEDAD;
		HipotecarController controller;

		try {
			Stage hipotecarPropiedadStage = new Stage();
			controller = (HipotecarController) FXUtils.cargarStage(
					hipotecarPropiedadStage, fxml,
					"Monopoly - Hipotecar Propiedad", false, false,
					Modality.APPLICATION_MODAL, StageStyle.UTILITY);
			controller.setCurrentStage(hipotecarPropiedadStage);
			controller.setPrevStage(currentStage);
			controller.setUsuarioLogueado(usuarioLogueado);
			int senderId = ConnectionController.getInstance().getIdPlayer();
			ConnectionController.getInstance().send(
					new GetMortgagesMessage(senderId,
							estadoActual.currentPlayer));
		} catch (Exception ex) {
			GestorLogs.registrarException(ex);

			final Alert alert = new Alert(AlertType.ERROR);

			alert.setTitle("Error...");
			alert.setContentText(ex.getMessage());
			alert.getButtonTypes().setAll(
					new ButtonType("Aceptar", ButtonData.OK_DONE));
			alert.showAndWait();
		}
	}

	@FXML
	void processDeshipotecar(ActionEvent event) {

	}

	@FXML
	void processComercializar(ActionEvent event) {

	}

	@FXML
	void processSendMessage(ActionEvent event) {
		sendChatMessage();
	}

	@FXML
	void processfinalizarTurno(ActionEvent event) {
		try {
			finalizarTurno();
		} catch (Exception ex) {
			GestorLogs.registrarError(ex);
			showMessageBox(AlertType.ERROR, "Error...", null, ex.getMessage());
		}
	}

	@FXML
	void processBancarrota(ActionEvent event) {

	}

	@FXML
	void processGuardar(ActionEvent event) {
		this.guardarJuego();
		// this.cerrar(true);
		/*
		 * Cierro la ventana cuando llega la confirmación de que el juego se
		 * guardó sin problemas
		 */
	}

	@FXML
	void processAbandonar(ActionEvent event) {
		this.cerrar(false);
	}

	// ======================================================================//
	// ========================== Getter & Setter ===========================//
	// ======================================================================//

	public static TableroController getInstance() {
		if (instance == null)
			instance = new TableroController();
		return instance;
	}

	public MenuButton getBtnAcciones() {
		return btnAcciones;
	}

	public void setBtnAcciones(MenuButton btnAcciones) {
		this.btnAcciones = btnAcciones;
	}

	public Stage getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(Stage currentStage) {
		this.currentStage = currentStage;
	}

	public Stage getPrevStage() {
		return prevStage;
	}

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

	public Deuda getDeudaPendiente() {
		return deudaPendiente;
	}

	public void setDeudaPendiente(Deuda deudaPendiente) {
		this.deudaPendiente = deudaPendiente;
	}
}
