package dbp.hackathon.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Iterable<Ticket> findByEstudianteId(Long estudianteId);
    Optional<Ticket> findByQrCode(String qrCode);
}
