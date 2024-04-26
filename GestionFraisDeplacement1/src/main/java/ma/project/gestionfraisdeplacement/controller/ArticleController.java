package ma.project.gestionfraisdeplacement.controller;



import java.util.Date;

import java.util.List;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;



import ma.project.gestionfraisdeplacement.entites.Article;

import ma.project.gestionfraisdeplacement.entites.Demmande;

import ma.project.gestionfraisdeplacement.services.ArticleServices;



@CrossOrigin(origins = "*")

@RestController

@RequestMapping("api/article")

public class ArticleController {



    @Autowired

    private ArticleServices articleServices;



    @GetMapping("/all")

    public List<Article> findAll() {

        return articleServices.findAll();

    }



    @PostMapping("/save")

    public ResponseEntity<?> save(

            @RequestParam("nom") String nom,

            @RequestParam("message") String message,

            @RequestParam("imageBon") MultipartFile imageBon,

            @RequestParam("position") String position,

            @RequestParam("date") Date date

    ) {



        try {

            Article article = new Article();

            article.setNom(nom);

            article.setMessage(message);

            article.setPosition(position);

            article.setDate(date);

            if (imageBon != null && !imageBon.isEmpty()) {

                article.setImageBon(imageBon.getBytes());

            }



            Article savedArticle = articleServices.save(article);





            return new ResponseEntity<>(savedArticle, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>("Erreur lors de la sauvegarde de la demande : " + e.getMessage(),

                    HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



    @GetMapping("/{id}")

    public Optional<Article> findById(@PathVariable("id") Long id) {

        return articleServices.findById(id);

    }



    @DeleteMapping("/{id}")

    public void deleteById(@PathVariable Long id) {

        articleServices.deleteById(id);

    }



}