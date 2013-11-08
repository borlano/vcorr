package ru.sveta.web.webservices;

import com.google.gson.Gson;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import ru.sveta.algorithm.Experiment;
import ru.sveta.algorithm.VariablesPool;

/**
 * REST Web Service
 *
 * @author rogvold
 */
@Path("algorithm")
public class AlgorithmResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlgorithmResource
     */
    public AlgorithmResource() {
    }

    /**
     * Retrieves representation of an instance of
     * ru.sveta.web.webservices.AlgorithmResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces("application/json")
    @Path("calc")
    public String getV(@QueryParam("data") String data) {
        StringTokenizer st = new StringTokenizer(data, "_");
        double[] d = new double[11];
        int i = 0;
        while (st.hasMoreTokens()) {
            d[i] = Double.parseDouble(st.nextToken());
            i++;
        }
        Experiment e = new Experiment();
        return (new Double(e.execute(d))).toString();
    }

    @GET
    @Produces("application/json")
    @Path("plot")
    public String getPlot(@QueryParam("id") int id) {
        if (id == 11) {
            List<List<double[]>> list = (new VariablesPool()).getPlotOfVariable(0, true);
            return (new Gson()).toJson(list);
        }
        List<List<double[]>> list = (new VariablesPool()).getPlotOfVariable(id, false);
        return (new Gson()).toJson(list);
    }

    /**
     * PUT method for updating or creating an instance of AlgorithmResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
