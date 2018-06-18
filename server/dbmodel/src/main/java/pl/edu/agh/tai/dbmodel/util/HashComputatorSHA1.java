package pl.edu.agh.tai.dbmodel.util;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;


@Component
public class HashComputatorSHA1 implements HashComputator {

    @Override
    public String getComputedHash(Hashable dbObject) {
        HashFunction hashFunction = Hashing.sha256();

        return hashFunction.newHasher()
                .putString(dbObject.getItemsUsedInHash().toString(), Charsets.UTF_8)
                .hash().toString();
    }
}
