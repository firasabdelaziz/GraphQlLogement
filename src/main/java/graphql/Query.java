package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {

private RendezVousRepository rdr;
private LogementRepository lgr;
public Query(RendezVousRepository rdr,LogementRepository lgr)
{
    this.rdr=rdr;
    this.lgr=lgr;
}

    public List<RendezVous> getAllRdv(){

        return rdr.getListeRendezVous();
    }
public List<Logement> getAllLogement(){
    return lgr.getAllLogements();
}
  public RendezVous  getRdvbyId(int id)
  {
      return rdr.getRDVbyid(id);
  }
   public Logement getLogementbyRef(int ref){
    return lgr.getLogementsByReference(ref);
   }

}
