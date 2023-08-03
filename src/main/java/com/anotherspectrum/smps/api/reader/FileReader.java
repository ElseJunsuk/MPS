package com.anotherspectrum.smps.api.reader;

import com.anotherspectrum.smps.util.logtypes.LT;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static com.anotherspectrum.smps.util.Logger.*;

/**
 * DB에 수록된 데이터를 메인 메모리 스트림(테스크)에 역/직렬화합니다.
 * <p>저장 담당 자료구조는 {@link Set}<{@link String}> 클래스입니다.</p>
 * <p>로드 시, 제네릭스에 등록된 클래스로 역직렬화하여 로드합니다.</p>
 *
 * @param <T> 역/직렬화 클래스
 */
public abstract class FileReader<T> {

    private String path;
    private File folder;
    private File[] files;

    public FileReader(@NotNull String path) {
        this(path, null);
    }

    public FileReader(@NotNull String path, @Nullable String info) {
        this.path = Bukkit.getPluginsFolder().getAbsolutePath() + File.separator + "MPS" + File.separator + path.replace("/", File.separator);
        this.folder = new File(this.path);
        if (folder.mkdirs()) {
            log(LT.FILE, "[ " + info + " ] 컨텐츠의 폴더를 생성했습니다.");
            return;
        }
        this.files = folder.listFiles();
        if (files != null && files.length > 0) {
            log(LT.FILE, "[ " + info + " ] 컨텐츠의 파일 검사를 시작합니다...");
            Arrays.stream(files).forEach(v -> {
                // check Names
                boolean matches = Pattern.matches("^[0-9|a-z|A-Z|_]*$", v.getName());
                if (matches) {
                    warn(LT.FILE, "  → " + RED + "'" + v.getName() + "'" + RESET + " 파일 이름에 공백, 한글 혹은 특수문자가 포함되어 있습니다!");
                    return;
                }
                log(LT.FILE, "  → " + GREEN + "'" + v.getName() + "'" + RESET + " 파일을 로드했습니다.");
            });
            log(LT.FILE, "[" + info + "] 컨텐츠 검사가 완료되었습니다. 총 " + GREEN + files.length + RESET + "개의 파일을 로드했습니다.");
        } else log(LT.FILE, "[ " + info + " ] 컨텐츠 폴더에 파일이 존재하지 않습니다.");
    }

    abstract public Map<String, String> serialize();
    abstract public T deserialize(Map<String, String> value);

    public File[] getFiles() {
        return files;
    }

    public String getPath() {
        return path;
    }

    public File getFolder() {
        return folder;
    }

    @Override
    public String toString() {
        return "FileReader{" +
                "path='" + path + '\'' +
                ", folder=" + folder +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}
