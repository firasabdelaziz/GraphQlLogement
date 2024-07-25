package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Mutation implements GraphQLRootResolver {
private RendezVousRepository rdr;
private LogementRepository lgr;

    public Mutation(RendezVousRepository rdr, LogementRepository lgr) {
        this.rdr = rdr;
        this.lgr = lgr;
    }

    public List<RendezVous> createRendezVous(int id,
                                             String date,
                                             String heure,
                                             int refLog,
                                             String num){
        Logement l=lgr.getLogementsByReference(refLog);
        RendezVous r=new RendezVous(id,date,heure,l,num);
        if(rdr.addRendezVous(r))
            return rdr.getListeRendezVous();

        return null;
    }
    public boolean updateRendezVous(int id,
                     String date,
                     String heure,
                     String numTel){


        Logement l=rdr.getLogementByRDV(id);
        RendezVous r2=new RendezVous(id,date,heure,l,numTel);
        return rdr.updateRendezVous(r2);
    }

    public Logement createLogement(int reference, String adresse){

        Logement l=new Logement(reference,adresse);
        if(lgr.saveLogement(l))
            return l;
        return null;
    }
}
