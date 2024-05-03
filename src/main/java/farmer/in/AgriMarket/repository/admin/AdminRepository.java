package farmer.in.AgriMarket.repository.admin;


import farmer.in.AgriMarket.model.admin.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, String> {

    AdminModel findByAdminId(String adminId);
}
