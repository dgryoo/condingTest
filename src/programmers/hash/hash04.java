package programmers.hash;

import java.util.*;
import java.util.stream.Collectors;

public class hash04 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = solution(genres,plays);

        for (int a : result) {
            System.out.println(a);
        }
    }

    static int[] solution(String[] genres, int[] plays) {

        List<Music> musicList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            musicList.add(new Music(genres[i], plays[i], i));
        }

        for (Music music : musicList) {
            System.out.println(music.toString());
        }

        HashMap<String,Integer> genreCounter = new HashMap<>();
        HashMap<String,Music> firstMap = new HashMap<>();
        HashMap<String,Music> secondMap = new HashMap<>();

        for (Music music : musicList) {
            if(!genreCounter.containsKey(music.getGenre())) {
                genreCounter.put(music.getGenre(), music.getPlay());
            } else {
                genreCounter.put(music.getGenre(), genreCounter.get(music.getGenre()) + music.getPlay());
            }

            if(!firstMap.containsKey(music.getGenre())) {
                firstMap.put(music.getGenre(), music);
            } else if (firstMap.get(music.getGenre()).getPlay() < music.getPlay()) {
                secondMap.put(music.getGenre(), firstMap.get(music.getGenre()));
                firstMap.put(music.getGenre(), music);
            } else if (!secondMap.containsKey(music.getGenre())) {
                secondMap.put(music.getGenre(), music);
            } else if(secondMap.get(music.getGenre()).getPlay() < music.getPlay()) {
                secondMap.put(music.getGenre(), music);
            }
        }

        List<String> genreCounterList = genreCounter.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        for(String genre : genreCounterList) {
            System.out.println(genre);
        }

        List<Integer> resultList = new ArrayList<>();

        for (String genre : genreCounterList) {
            resultList.add(firstMap.get(genre).getIndex());
            if(secondMap.containsKey(genre)) {
                resultList.add(secondMap.get(genre).getIndex());
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();


    }

    static class Music {
        private String genre;
        private int play;
        private int index;

        public Music(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {

            return "genre : " + genre + ", play : " + play + ", index : " + index;
        }

    }
}
