package ma.project.gestionfraisdeplacement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.project.gestionfraisdeplacement.entites.Article;
import ma.project.gestionfraisdeplacement.repository.ArticleRepository;

@Service
public class ArticleServices {
	@Autowired
	private ArticleRepository articleRepository;

	public List<Article> findAll() {
		return articleRepository.findAll();
	}


	public Article save(Article entity) {
		return articleRepository.save(entity);
	}

	public Article updateProduit(Long id, Article article) {
		Article p = findById(id).get();
		p.setNom(article.getNom());
		p.setMessage(article.getMessage());

		articleRepository.save(p);
		return p;
	}
	public Optional<Article> findById(Long id) {
		return articleRepository.findById(id);
	}

	public void deleteById(Long id) {
		articleRepository.deleteById(id);
	}

	public void deleteAll() {
		articleRepository.deleteAll();
	}

}
