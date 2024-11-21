package net.edigest.journalApp.controller;


import net.edigest.journalApp.controller.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/Journal")
public class JournalEntryController {

    private final Map<Long, JournalEntry> journalEntry = new HashMap<>();
    @GetMapping
public List<JournalEntry> getAll(){
    return new ArrayList<>(journalEntry.values());
}
  @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntry.put((myEntry.getId()),myEntry);
   return true;
}
   @GetMapping ("/id/{myID}")
    public JournalEntry  getEntry(@PathVariable Long myID){
       return   journalEntry.get(myID) ;

   }
  @DeleteMapping ("/id/{myID}")
    public JournalEntry deleteEntry(@PathVariable Long myID){
        return journalEntry.remove(myID) ;

  }
  @PutMapping ("/id/{myID}")
   public JournalEntry putEntry(@PathVariable Long myID,@RequestBody JournalEntry myEntry){
        return  journalEntry.put(myID,myEntry);
  }

}
