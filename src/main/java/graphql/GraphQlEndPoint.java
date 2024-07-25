package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQlEndPoint extends SimpleGraphQLServlet {
    public GraphQlEndPoint()
    {super(builSchema());}
    private static GraphQLSchema builSchema(){
        LogementRepository lgr=new LogementRepository();
        RendezVousRepository rdr=new RendezVousRepository();
        return SchemaParser.newParser()
                .file("schema.graphqls")
                .resolvers(new Query(rdr,lgr),
                        new Mutation(rdr,lgr))
                .build().makeExecutableSchema();

    }


}
