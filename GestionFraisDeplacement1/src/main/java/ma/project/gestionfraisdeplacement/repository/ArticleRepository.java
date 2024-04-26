package ma.project.gestionfraisdeplacement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.project.gestionfraisdeplacement.entites.Article;

 

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
