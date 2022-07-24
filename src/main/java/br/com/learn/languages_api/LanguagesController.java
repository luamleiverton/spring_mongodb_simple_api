package br.com.learn.languages_api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguagesController {

  //private List<LanguageModel> languages = 
    //List.of(
    //  new LanguageModel("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
    //  new LanguageModel("Python", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png", 2)
    //  );

    @Autowired
    private LanguageRepository repositorio;
  
  @GetMapping("/list_languages")
  public List<Language> getLanguage() {
    List<Language> languages = repositorio.findAll();
    return languages;
  }

  @PostMapping("/list_languages")
  public Language cadastrarLinguagem(@RequestBody Language language) {
    Language savedLanguage = repositorio.save(language);
    return savedLanguage;
  }

}
