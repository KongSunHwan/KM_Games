package ac.kmgames.model.repository;

import ac.kmgames.model.entity.GamePhoto;
import ac.kmgames.model.entity.GamePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface GamePhotoRepository extends JpaRepository<GamePhoto, Long> {

    /**
     * Find GamePhoto by the gallery ID
     *
     * @param gamePostId
     * @return
     */
    public List<GamePhoto> findAllByGamePostId(Long gamePostId);

    /**
     * Delete GamePhoto by the delete file list
     *
     * @param deleteFileList
     */
    @Modifying
    @Query(value = "DELETE FROM GamePhoto p " +
            "WHERE p.id IN (:deleteFileList)")
    public void deleteByGamePhotoIdList(@Param("deleteFileList") List<Long> deleteFileList);
}
