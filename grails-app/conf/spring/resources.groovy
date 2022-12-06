// Place your Spring DSL code here
import au.org.ala.userdetails.marshaller.*;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

beans = {
    customObjectMarshallers(CustomObjectMarshallers){
        marshallers =[
                new UserPropertyMarshaller(),
                new UserMarshaller()
        ]
    }
    localeResolver(FixedLocaleResolver, new Locale('en_GB'))
}
