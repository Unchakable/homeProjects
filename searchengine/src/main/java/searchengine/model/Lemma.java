package searchengine.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "lemma")
public class Lemma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "site_id")
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Site site;

    @Column(columnDefinition = "VARCHAR(255)")
    @NotNull
    private String lemma;

    @NotNull
    private int frequency;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "search_index",
            joinColumns = {@JoinColumn(name = "lemma_id")},
            inverseJoinColumns = {@JoinColumn(name = "page_id")})
    private List<Page> listPage;
}
