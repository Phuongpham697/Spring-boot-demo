package net.codejava;

import org.springframework.data.domain.Page;

import java.util.List;

public interface UseServiceInterface {

    public Page<Use> listAll(int pageNum);

    public List<Use> listSearch(String keyword);

    public void save(Use use);

    public Use get(long id);

    public void delete(long id);


}
