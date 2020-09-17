package rabbitmq.fileconfig;


import java.io.File;

public class BatchFileFactory {
    private String absolutePath;
    private int chunkSize;
    private final int defaultChunkSize = 10;

    public BatchFileFactory() {
        chunkSize = defaultChunkSize;
    }

    public static BatchFileFactory create() {
        return new BatchFileFactory();
    }

    public BatchFileFactory setFileName(String absolutePath) {
        this.absolutePath = absolutePath;
        return this;
    }

    public BatchFileFactory setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
        return this;
    }

    public void build() {
        if ( doesFileExistsAlready() ) {

        }
    }

    public BatchFileFactory afterPropertiesSet() {
        if (isFileNameNull()) {
            throw new RuntimeException("File Name cannot be null in BatchFileFactory!");
        }
        if (isFilePathADirectory()) {
            throw new RuntimeException("File Path "+this.absolutePath+" is a directory!!");
        }
        return this;
    }

    private boolean doesFileExistsAlready() {
        File file = new File(this.absolutePath);
        return file.exists();
    }

    private boolean isFilePathADirectory() {
        File file = new File(this.absolutePath);
        return file.isDirectory();
    }

    private boolean isFileNameNull() {
        return absolutePath == null;
    }
}
