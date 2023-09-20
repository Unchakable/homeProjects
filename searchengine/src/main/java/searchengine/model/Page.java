package searchengine.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "page")
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "site_id")
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Site site;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String path;

    @NotNull
    private int code;

    @Column(columnDefinition = "MEDIUMTEXT")
    @NotNull
    private String content;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "search_index",
            joinColumns = {@JoinColumn(name = "page_id")},
            inverseJoinColumns = {@JoinColumn(name = "lemma_id")})
    private List<Lemma> listLemma;
}
