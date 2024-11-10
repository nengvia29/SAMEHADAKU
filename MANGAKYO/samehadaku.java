import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ComicController {

    private List<Comic> comics;

    public ComicController() {
        comics = new ArrayList<>();
        comics.add(new Comic("Blue Lock", "Chapter 281"));
        comics.add(new Comic("DANDADAN", "Chapter 173"));
        comics.add(new Comic("One Piece", "Chapter 1131"));
        comics.add(new Comic("Solo Leveling: Ragnarok", "Chapter 27"));
    }

    @PostMapping("/search")
    public List<Comic> searchComics(@RequestBody SearchRequest request) {
        List<Comic> result = new ArrayList<>();
        for (Comic comic : comics) {
            if (comic.getTitle().toLowerCase().contains(request.getSearchText().toLowerCase())) {
                result.add(comic);
            }
        }
        return result;
    }
}

class Comic {
    private String title;
    private String chapter;

    public Comic(String title, String chapter) {
        this.title = title;
        this.chapter = chapter;
    }

    public String getTitle() {
        return title;
    }

    public String getChapter() {
        return chapter;
    }
}

class SearchRequest {
    private String searchText;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
