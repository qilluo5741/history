package com.xtc.service;

import java.io.File;
import java.io.InputStream;

public abstract interface FileService{
  public abstract String getUrl(String paramString1, String paramString2);

  public abstract String getUrl(String paramString);

  public abstract String upload(File paramFile, String paramString);

  public abstract String upload(File paramFile, String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract String upload(InputStream paramInputStream, String paramString);

  public abstract String upload(InputStream paramInputStream, String paramString1, String paramString2, String paramString3, String paramString4);

  public abstract String upload(InputStream paramInputStream, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);

  public abstract File get(String paramString);

  public abstract void delete(String paramString);

  public abstract String basePath();

  public abstract String uploadAvatar(String paramString, InputStream paramInputStream);

  public abstract String uploadImage(InputStream paramInputStream);

  public abstract String imageType(InputStream paramInputStream);
}