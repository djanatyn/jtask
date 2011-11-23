task :task do
  sh "javac Task.java"
  puts "compiled task"
end

task :prompt do
  sh "javac Prompt.java"
  puts "compiled prompt"
end

task :default => [:task, :prompt] do
  sh "javac JTask.java"
  puts "compiled application - ready to go!"
end
