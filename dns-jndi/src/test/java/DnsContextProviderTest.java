import io.github.hurynovich.jndi.DnsContextProvider;
import org.junit.Test;

import javax.naming.NamingException;

public class DnsContextProviderTest {

    @Test
    public void callDnsName() throws NamingException {
        DnsContextProvider provider = new DnsContextProvider();
        Object obj = provider.provideContext().getAttributes("");

        System.out.println(obj);
    }

}
