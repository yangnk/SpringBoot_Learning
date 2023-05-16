package com.yangnk.TCCSample1;

import com.yangnk.dao.ExperienceMapper;
import com.yangnk.dao.GpuMapper;
import com.yangnk.entity.Experience;
import com.yangnk.entity.ExperienceExample;
import com.yangnk.entity.Gpu;
import com.yangnk.entity.GpuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionalServiceImpl implements TransactionalService {

    @Autowired
    GpuMapper gpuMapper;

    @Autowired
    ExperienceMapper experienceMapper;


    @Override
    public void tryOperation(Integer count, Integer experiment) {

        //获取gpu卡的数量
        List<Gpu> gpus = gpuMapper.selectByExample(new GpuExample());
        Integer stockCount = gpus.get(0).getCount();

        if (stockCount >= count) {
            Experience experience = new Experience(experiment, "WAIT");
            experienceMapper.insert(experience);

            Gpu gpu = new Gpu(1, stockCount - count);
            gpuMapper.updateByExample(gpu, new GpuExample());
        } else{
            throw new RuntimeException("GPU数量不够");
        }
    }

    @Override
    public void confirmOperation(Integer experiment) {

        //将试验的状态更新为完成
        Experience experience = new Experience(experiment, "DONE");
        experienceMapper.updateByExample(experience, new ExperienceExample());

    }

    @Override
    public void cancelOperation(Integer count, Integer experiment) {
        //删除试验记录
        Experience experience = new Experience(experiment, "DONE");
        experienceMapper.deleteById(experiment);

        //获取gpu卡的数量
        List<Gpu> gpus = gpuMapper.selectByExample(new GpuExample());
        Integer stockCount = gpus.get(0).getCount();

        Gpu gpu = new Gpu(experiment, stockCount + count);
        gpuMapper.updateByExample(gpu, new GpuExample());
    }
}
