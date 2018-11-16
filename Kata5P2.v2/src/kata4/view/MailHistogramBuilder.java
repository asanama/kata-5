package kata4.view;

import java.util.List;
import kata4.model.Histogram;
import kata4.model.Mail;

public class MailHistogramBuilder {
    public Histogram<String> buildHist(List<String> email){
        Histogram<String> hist = new Histogram<>();
        Mail m = new Mail();
        for(String s : email){
            String domain = m.getDomain(s);
            if(domain.length() > 0) hist.putKey(domain);
        }   
        return hist;
    }
}
