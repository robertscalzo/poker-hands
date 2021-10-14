package workshop.pokerhands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoolController {

    @GetMapping("/coolstuff")
    public ResponseEntity<String> getCoolStuff() {
        return ResponseEntity.ok().body("We are so cool.");
    }
}
