package ma.pfa.invoicemanagement.metier;


import ma.pfa.invoicemanagement.dao.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EntrepriseUserDetailService implements UserDetailsService {
    @Autowired
    private EntrepriseManager entrepriseManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Entreprise entreprise = entrepriseManager.getEntrepriseByUsername(username);
        if (entreprise == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(entreprise.getUsername())
                .password(entreprise.getPassword())
                .roles("USER")
                .build();
    }

}