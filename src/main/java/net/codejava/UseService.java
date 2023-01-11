package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UseService implements UseServiceInterface
{
    @Autowired
    private UseRepository repo;

    @Override
    public Page<Use> listAll(int pageNum)
    {
        Pageable pageable = PageRequest.of(pageNum - 1, 5);

        return repo.findAll(pageable);
    }

    @Override
    public List<Use> listSearch(String keyword)
    {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    @Override
    public void save(Use use)
    {
        System.out.println(use.getId());
        repo.save(use);
    }

    @Override
    public Use get(long id)
    {
        return repo.findById(id).get();
    }

    @Override
    public void delete(long id)
    {
        repo.deleteById(id);
    }
}
