import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    private Vector2 playerCoord;
    private float movementSpeed = 1.3f;
    private Vector2 movementVector = new Vector2(0, 1);

    float x = 0;
    float y = 0;
    
    @Override
    public void start(Stage primaryStage) {
        playerCoord = new Vector2(200, 200); // Başlangıç koordinatları

        Pane root = new Pane();
        Circle playerCircle = new Circle(playerCoord.getX(), playerCoord.getY(), 10); // Oyuncu karakterini temsil eden bir daire

        root.getChildren().add(playerCircle);

        Scene scene = new Scene(root, 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Character Movement");
        
        
     // Klavye olay dinleyicisi ekle
        scene.setOnKeyPressed(e -> {
            KeyCode keyCode = e.getCode();
            if (keyCode == KeyCode.W) {
                // Yukarı hareket
                y += 1 * movementSpeed;
            } else if (keyCode == KeyCode.A) {
                // Sola hareket
                x += -1 * movementSpeed;
            } else if (keyCode == KeyCode.S) {
                // Aşağı hareket
                y += -1 * movementSpeed;
            } else if (keyCode == KeyCode.D) {
                // Sağa hareket
                x += 1 * movementSpeed;
            }
        });
        scene.setOnKeyReleased(e -> {
            KeyCode keyCode = e.getCode();
            if (keyCode == KeyCode.W) {
                // Yukarı hareket
                y -= 1 * movementSpeed;
            } else if (keyCode == KeyCode.A) {
                // Sola hareket
                x -= -1 * movementSpeed ;
            } else if (keyCode == KeyCode.S) {
                // Aşağı hareket
                y -= -1 * movementSpeed;
            } else if (keyCode == KeyCode.D) {
                // Sağa hareket
                x -= 1 * movementSpeed;
            }
        });


        primaryStage.show();
        
        movementVector.multipleScalar(movementSpeed);
        
        
        
        // Hareket döngüsü
        new Thread(() -> {
            while (true) {
            	movementVector = new Vector2(x,-y);
            	
                playerCoord.add(movementVector);
                // JavaFX'de UI güncellemeleri Platform.runLater kullanılarak yapılır
                javafx.application.Platform.runLater(() -> {
                    playerCircle.setCenterX(playerCoord.getX());
                    playerCircle.setCenterY(playerCoord.getY());
                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
