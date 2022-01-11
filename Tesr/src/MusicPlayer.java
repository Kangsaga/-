
import java.util.ArrayList;

import javazoom.jl.player.MP3Player;

public class MusicPlayer {

	MP3Player mp3 = new MP3Player();

	ArrayList<Music> musicList = new ArrayList<Music>();

	public MusicPlayer() {
		musicList.add(new Music("FIFA2", "C://music/FIFA2.mp3"));
		musicList.add(new Music("UEFA 챔피언스리그 공식 테마송", "c://music/UEFA 챔피언스리그 공식 테마송.mp3"));
	}

	int i = 0;

	public void play() {
		mp3.play(musicList.get(i).getPath());
	}

	public void stop() {
		mp3.stop();
	}

	public void channelUpOrDown(int a) {
		if (a >= 0) {
			i++;
		} else {
			i--;
		}
		stop();
		play();
	}
}
