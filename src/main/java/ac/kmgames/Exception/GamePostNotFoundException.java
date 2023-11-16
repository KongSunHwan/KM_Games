package ac.kmgames.Exception;

public class GamePostNotFoundException extends RuntimeException {

    public GamePostNotFoundException(long gameId) {
        super("게임 ID " + gameId + "에 해당하는 게임을 찾을 수 없습니다.");
    }
}
