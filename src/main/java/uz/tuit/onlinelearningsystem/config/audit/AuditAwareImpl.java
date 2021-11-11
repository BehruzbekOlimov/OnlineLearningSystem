package uz.tuit.onlinelearningsystem.config.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import uz.tuit.onlinelearningsystem.entity.User;

import java.util.Optional;
import java.util.UUID;

public class AuditAwareImpl implements AuditorAware<UUID> {
    @Override
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication == null || !authentication.isAuthenticated()
                || "anonymousUser".equals("" + authentication.getPrincipal()))){
            try {
                return Optional.of(((User) authentication.getPrincipal()).getId());
            }catch (Exception e){
                return Optional.empty();
            }

        }
            return Optional.empty();
    }
}
